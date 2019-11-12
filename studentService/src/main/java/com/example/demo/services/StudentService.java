package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repos.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public Student add(Student student) {
		return this.repo.save(student);
	}
	
	public Optional<Student> findById(long id){
		return this.repo.findById(id);
	}
	
	public List<Student> findAll(){
		return this.repo.findAll();
	}
	
	public List<Student> findByName(String name){
		return this.repo.findByStudentName(name);
	}
	
	public List<Student> findByTeacherId(long id){
		return this.repo.findByStudentTeacherId(id);
	}
	
	public void deleteById(long id) {
		 this.repo.deleteById(id);
	}
	
	public Student update(Student student) {
		Student updateStudent = null;
		if(this.repo.existsById(student.getStudentId())) {
			updateStudent = this.repo.save(student);
		}
		return updateStudent;
	}
}
