package com.project.foodOderingSystem.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.project.foodOderingSystem.service.UserService;

import antlr.collections.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.project.foodOderingSystem.entity.User userr= userService.loadUserByUsername(username);
		if(userr != null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userr.getRole());
			Collection<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
			list.add(authority);
			return new User(userr.getUserName(),userr.getPassword(),list);
		}
		else
		{
			throw new UsernameNotFoundException("User Not found!!");
		}
		
	}

}
