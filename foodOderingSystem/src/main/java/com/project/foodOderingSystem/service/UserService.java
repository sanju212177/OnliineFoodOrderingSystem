package com.project.foodOderingSystem.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.project.foodOderingSystem.dto.UserDto;
import com.project.foodOderingSystem.entity.Customer;


public interface UserService {

	Integer signUpUser(@Valid UserDto userDto);
	Customer signInUser(UserDto userDto);
	
}
