package com.project.foodOderingSystem.security;


public class JwtRequest {
     private String username;
     private String password;
     
     public JwtRequest() {
    	 
     }
    

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String passward) {
		this.password = passward;
	}


	@Override
	public String toString() {
		return "JwtRequest [username=" + username + ", password=" + password + "]";
	}
      
     
}
