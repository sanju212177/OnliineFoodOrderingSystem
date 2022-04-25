package com.project.foodOderingSystem.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.project.foodOderingSystem.dto.UserDto;
import com.project.foodOderingSystem.entity.Customer;
import com.project.foodOderingSystem.entity.User;


public interface UserService {

	Integer signUpUser(@Valid UserDto userDto);
	Customer signInUser(UserDto userDto);
//	Customer getCustomer(Integer userId);
	User loadUserByUsername(String userName);
	boolean checkUser(@Valid UserDto userDto);
	
}
