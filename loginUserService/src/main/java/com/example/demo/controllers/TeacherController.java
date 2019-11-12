package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private LoadBalancerClient balancer;
	
	private String getStudentServiceUri() {
		ServiceInstance instance = balancer.choose("student-service");
		
		return instance.getUri().toString();
	}
	
	private String getAttendanceServiceUri() {
		ServiceInstance instance = balancer.choose("attendance-service");
		
		return instance.getUri().toString();
	}
	
	
	@PostMapping(path = "/student")
	public ResponseEntity<String> addStudent(@RequestBody Object student) {
		String uri = getStudentServiceUri();
		
		uri = uri + "/students/add";
		
		return this.template.postForEntity(uri, student, String.class);
	}
	
	
	@DeleteMapping(path = "/student/delete/{id}")
	public void deleteStudent(@PathVariable("id") long id) {
		String uri = getStudentServiceUri();
		
		uri = uri + "/students/delete"+id;
		
		this.template.delete(uri);
	}
	
	
	@PutMapping(path = "/student/update")
	public void updateStudent(@RequestBody Object student) {
		String uri = getStudentServiceUri();
		
		uri = uri+"/students/update";
		
		this.template.put(uri, student);
	}
	
	@PostMapping(path = "/attendance/add")
	public ResponseEntity<String> addAttendance(@RequestBody Object attendance){
		String uri = getAttendanceServiceUri();
		
		uri = uri + "/attendance";
		
		return this.template.postForEntity(uri, attendance, String.class);
	}
}
