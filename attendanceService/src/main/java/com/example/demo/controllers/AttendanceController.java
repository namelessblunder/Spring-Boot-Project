package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Attendance;
import com.example.demo.services.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService service;
	
	@PostMapping(path = "",produces = "application/json", consumes = "application/json")
	public Attendance addAttendance(@RequestBody Attendance attendance){
		return this.service.add(attendance);
	}
	
	@GetMapping(path = "", produces = "application/json")
	public List<Attendance> getAllAttendance(){
		return this.service.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public List<Attendance> getIdAttendance(@PathVariable("id") long id){
		return this.service.findByStudentId(id);
	}
	
	@GetMapping(path = "/{id}/month/{month}")
	public List<Attendance> getIdAttendanceOfMonth(@PathVariable("id")long id, @PathVariable("month")int month){
		return this.service.findByStudentAndMonth(id, month);
	}
	
	
}
