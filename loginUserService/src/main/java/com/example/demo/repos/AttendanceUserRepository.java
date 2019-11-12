package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AttendanceUser;

@Repository
public interface AttendanceUserRepository extends JpaRepository<AttendanceUser, Long> {

	public AttendanceUser findByUsername(String name);
}
