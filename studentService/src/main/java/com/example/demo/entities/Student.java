package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "STUDENTS64")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	private long studentId;
	
	private String studentName;
	
	//private LocalDate studentDob;
	
	private String studentYear;
	
	private long studentTeacherId;
}
