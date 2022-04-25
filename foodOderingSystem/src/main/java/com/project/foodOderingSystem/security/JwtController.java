package com.project.foodOderingSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class JwtController {
	
    @Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil; 
	
	@RequestMapping({"/food"})
	public String print() {
		return "helooooooooooooo its food ordering project working fine called by FOooDDDDDD  public api";
	}
	@RequestMapping({"/food1"})
	public String print2() {
		return "helooooooooooooo its food ordering project working fine called by USERRRRRRRRR public api";
	}
	
	@RequestMapping(value = "/token" , method = RequestMethod.POST)
    public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.err.println(jwtRequest);
		try{
		    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));	
		}
		catch ( BadCredentialsException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Bad credentials");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token =  this.jwtUtil.generateToken(userDetails);
		System.out.println("jwt "+ token);
		return ResponseEntity.ok(new JwtResponse(token));
    	
    }
}
