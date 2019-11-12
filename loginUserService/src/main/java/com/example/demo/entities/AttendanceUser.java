package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USERS64")
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceUser {

	@Id
	private long id;
	
	private String username;
	private String password;
	private String userType;
}
