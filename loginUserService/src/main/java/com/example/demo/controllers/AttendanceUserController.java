package com.example.demo.controllers;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AttendanceUser;
import com.example.demo.services.AttendanceUserService;

@RestController
@RequestMapping("/user")
public class AttendanceUserController {

	@Autowired
	private AttendanceUserService service;
	
	@GetMapping(path = "/{name}")
	public AttendanceUser findByUsername(@PathVariable("name")String username) {
		return this.service.findByUsername(username);
	}
	
	@GetMapping(path = "/id/{id}")
	public AttendanceUser findById(@PathParam("id")long id) {
		AttendanceUser foundUser = null;
		
		Optional<AttendanceUser> findUser = this.service.findById(id);
		
		if(findUser.isPresent()) {
			foundUser = findUser.get();
		}
		
		return foundUser;
	}
}
