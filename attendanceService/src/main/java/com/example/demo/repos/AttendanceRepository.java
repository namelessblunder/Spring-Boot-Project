package com.example.demo.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	public List<Attendance> findByStudentId(long id);
	
	public List<Attendance> findByStudentIdAndAbsentMonth(long id, int month);
	
	public List<Attendance> findByStudentIdAndAbsentDayAndAbsentMonthAndAbsentYear(long id, int day, int month, int year);
	
	public List<Attendance> findByStudentIdAndAbsentMonthAndAbsentYear(long id, int month, int year);
	
	public List<Attendance> findByAbsentDayAndAbsentMonthAndAbsentYear(int day, int month, int year);
	
	
}
