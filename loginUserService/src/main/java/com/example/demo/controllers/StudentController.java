package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

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
	
	
	@GetMapping(path = "/profile/{id}")
	public String getStudentProfile(@PathVariable("id") long id) {
		String uri = getStudentServiceUri();
		
		uri = uri + "/students/"+id;
		
		return this.template.getForObject(uri, String.class);
	}
	
	
	@GetMapping(path = "/attendance/{id}/{month}")
	public String getStudentAttendanceOfMonth(@PathVariable("id") long id, @PathVariable("month") int month) {
		String uri = getAttendanceServiceUri();
		
		uri = uri + "/attendance/"+id+"/month/"+month;
		
		return this.template.getForObject(uri, String.class);
	}
}
