package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AttendanceUser;
import com.example.demo.repos.AttendanceUserRepository;

@Service
public class AttendanceUserService {

	@Autowired
	private AttendanceUserRepository repo;
	
	public Optional<AttendanceUser> findById(long id) {
		return this.repo.findById(id);
	}
	
	public AttendanceUser findByUsername(String username){
		return this.repo.findByUsername(username);
	}
}
