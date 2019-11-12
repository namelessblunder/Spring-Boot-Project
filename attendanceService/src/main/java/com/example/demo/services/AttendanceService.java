package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Attendance;
import com.example.demo.repos.AttendanceRepository;

@Service
public class AttendanceService {

	private static final double FINE = 10;
	
	private static final int THRESHOLD = 4;
	
	@Autowired
	private AttendanceRepository repo;
	
	public Attendance add(Attendance attendance) {
		return this.repo.save(attendance);
	}
	
	public List<Attendance> findAll(){
		return this.repo.findAll();
	}
	
	public List<Attendance> findByStudentId(long id){
		return this.repo.findByStudentId(id);
	}
	
	public List<Attendance> findByDate(LocalDate date){
		return this.repo.findByAbsentDayAndAbsentMonthAndAbsentYear(date.getDayOfMonth(),date.getMonthValue(),date.getYear());
	}
	
	public void delete(Attendance attendence) {
		this.repo.delete(attendence);
	}
	
	public List<Attendance> findByStudentAndMonth(long id, LocalDate date){
		return this.repo.findByStudentIdAndAbsentMonth(id, date.getMonthValue());
	}
	
	public List<Attendance> findByStudentAndMonth(long id, int month){
		return this.repo.findByStudentIdAndAbsentMonth(id, month);
	}
	
}
