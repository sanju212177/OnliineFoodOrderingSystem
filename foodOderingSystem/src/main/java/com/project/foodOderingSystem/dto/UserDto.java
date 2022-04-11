package com.project.foodOderingSystem.dto;

import lombok.Getter;
import lombok.Setter;


public class UserDto {
	
	 private @Getter @Setter String userName;
     private@Getter @Setter String password; 
     private  @Getter @Setter CustomerDto customerDto;
   	 public String getUserName() {
		return userName;
	 }
	 public void setUserName(String userName) {
		this.userName = userName;
	 }
	 public String getPassword() {
		return password;
	 }
	 public void setPassword(String password) {
		this.password = password;
	 }
	 public CustomerDto getCustomerDto() {
		return customerDto;
	 }
     public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	 }
	 
     
}
