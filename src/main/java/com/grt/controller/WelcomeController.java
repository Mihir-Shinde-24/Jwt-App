package com.grt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grt.entity.AuthRequest;
import com.grt.util.JwtUtil;

@RestController
public class WelcomeController {

	// Create a POST API to Register User
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to Jwt App";
	}
	
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest )
	{
		try 
		{
			authenticationManager
						.authenticate(
								new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
					);
		} 
		catch (Exception e)
		{
			throw new RuntimeException("Invalid Username Password.");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
