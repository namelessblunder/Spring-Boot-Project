package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByStudentName(String name);
	public List<Student> findByStudentTeacherId(long teacherId);
}
