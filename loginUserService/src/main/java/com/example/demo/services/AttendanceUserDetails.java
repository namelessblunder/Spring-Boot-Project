package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AttendanceUser;
import com.example.demo.repos.AttendanceUserRepository;

@Service
public class AttendanceUserDetails implements UserDetailsService {

	@Autowired
	private AttendanceUserRepository repo; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AttendanceUser user = this.repo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + "not found in Database");
		}
		
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getUserType());
		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(authority);
		
		UserDetails userDetails = (UserDetails) new User(user.getUsername(),user.getPassword(),grantList);
		
		return userDetails;
	}

}
