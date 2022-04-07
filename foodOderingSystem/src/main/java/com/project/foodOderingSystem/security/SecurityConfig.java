package com.project.foodOderingSystem.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.project.foodOderingSystem.entity.User;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception{
         auth.inMemoryAuthentication()
	                        .withUser("user")
		                    .password(passwordEncoder().encode("180303"))
		                    .roles("ADMIN");
		    }
	 @Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/customers/create").hasRole("ADMIN").anyRequest().authenticated().and()
					.httpBasic();
			http.csrf().disable();
		}

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
}
