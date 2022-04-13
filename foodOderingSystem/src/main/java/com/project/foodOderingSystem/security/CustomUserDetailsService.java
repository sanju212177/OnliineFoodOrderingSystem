package com.project.foodOderingSystem.security;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(username.equals("foo")) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
			Collection<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
			list.add(authority);
			return new User("foo","foo",list);
		}
		else
		{
			throw new UsernameNotFoundException("User Not found!!");
		}
		
	}

}
