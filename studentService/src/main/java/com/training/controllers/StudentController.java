package com.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping(path = "", produces = "application/json", consumes = "application/json")
	public Student addStudent(@RequestBody Student student) {
		return this.service.add(student);
	}
	
	@GetMapping(path = "", produces = "application/json")
	public List<Student> findAllStudents(){
		return this.service.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Student findStudentById(@PathVariable ("id") long id) {
		Student foundStudent = null;
		
		Optional<Student> findStudent = this.service.findById(id);
		
		if(findStudent.isPresent()) {
			foundStudent = findStudent.get();
		}
		
		return foundStudent;
	}
	
	@GetMapping(path = "/name/{name}")
	public List<Student> findStudentsByName(@PathVariable("name") String name){
		return this.service.findByName(name);
	}
	
	@GetMapping(path = "/teacher/{id}")
	public List<Student> findStudentByTeacherId(@PathVariable("id") long id){
		return this.service.findByTeacherId(id);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteStudentById(@PathVariable("id") long id) {
		this.service.deleteById(id);
	}
	
	@PutMapping(path = "/update", produces = "application/json", consumes = "application/json")
	public Student updateStudent(@RequestBody Student student) {
		return this.service.update(student);
	}
}
