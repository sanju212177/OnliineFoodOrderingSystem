package com.project.foodOderingSystem.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.foodOderingSystem.entity.Address;
import com.project.foodOderingSystem.entity.Customer;
import com.project.foodOderingSystem.dto.UserDto;
import com.project.foodOderingSystem.entity.User;
import com.project.foodOderingSystem.repository.UserRepository;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	@Override
	public Integer signUpUser( UserDto userDto) {
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
        
		Customer customer = new Customer();
        customer.setCustomerName(userDto.getCustomerDto().getCustomerName());
        customer.setCustomerEmail(userDto.getCustomerDto().getCustomerEmail());
        customer.setPhoneNumber(userDto.getCustomerDto().getPhoneNumber());
		Address address = new Address();
		address.setCity(userDto.getCustomerDto().getAddress().getCity());
		address.setCountry(userDto.getCustomerDto().getAddress().getCountry());
		address.setPincode(userDto.getCustomerDto().getAddress().getPincode());
		address.setState(userDto.getCustomerDto().getAddress().getState());
		address.setStreet(userDto.getCustomerDto().getAddress().getStreet());
		customer.setAddress(address);
		user.setCustomer(customer);
        return userRepository.save(user).getCustomer().getCustomerId();
	}
	@Override
	public Customer signInUser(UserDto userDto) {
		List<User> users = userRepository.findAll();
		for(User user: users) {
			if(user.getUserName().equals(userDto.getUserName())
					&& user.getPassword().equals(userDto.getPassword()))
			return user.getCustomer();
		}
		return null;
	}
	@Override
	public User loadUserByUsername(String userName) {
		
		return userRepository.loadUserByUsername(userName);
	}
	@Override
	public boolean checkUser(@Valid UserDto userDto) {
		// TODO Auto-generated method stub
		List<User> userList = userRepository.findAll();
		for(User i : userList) {
			if(i.getUserName().equals(userDto.getUserName()))return true;
		}
		return false;
	}

}
