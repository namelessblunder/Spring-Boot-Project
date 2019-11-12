package com.example.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AttendanceUserSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/login","/","/logout").permitAll().and().csrf().disable();
			
		http.authorizeRequests().antMatchers("/teacher").access("hasRole('TEACHER')").and().csrf().disable();	//Allow User with teacher role to access /teacher methods
		
		http.authorizeRequests().antMatchers("/student").access("hasRole('STUDENT')").and().csrf().disable();	//Allow USer with student role to access /student methods
		
		http.authorizeRequests().and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and().logout().logoutUrl("/logout").and().csrf().disable();
		
	}
	

	
}
