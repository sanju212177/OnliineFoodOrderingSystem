package com.project.foodOderingSystem.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodOderingSystem.dto.UserDto;
import com.project.foodOderingSystem.entity.Customer;
import com.project.foodOderingSystem.entity.User;
import com.project.foodOderingSystem.service.UserService;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@PostMapping("/signUp")
    public ResponseEntity<String> signUpUser(@Valid @RequestBody UserDto userDto){
		if(userService.checkUser(userDto)==true)
			return new ResponseEntity<String>("Username already exist!!!",HttpStatus.NOT_ACCEPTABLE);
	
		return new ResponseEntity<String>("created" + String.valueOf(userService.signUpUser(userDto)) ,HttpStatus.CREATED);
    }     
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> signInUser(@RequestBody UserDto userDto){
		return new ResponseEntity<Customer>(userService.signInUser(userDto),HttpStatus.ACCEPTED);
	}
	
// getting customer by userid	
	@GetMapping("/getUser/{userName}")
	public ResponseEntity<User> loadUserByUsername(@PathVariable("userName") String userName){
		return new ResponseEntity<User>(userService.loadUserByUsername(userName),HttpStatus.ACCEPTED);
		
	}
}
