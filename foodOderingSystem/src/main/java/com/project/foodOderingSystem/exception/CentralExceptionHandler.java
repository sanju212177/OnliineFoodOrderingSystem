package com.project.foodOderingSystem.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class CentralExceptionHandler {
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<String> exceptionaHandler1(InvalidFormatException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> exceptionaHandler1(MethodArgumentNotValidException e){
		String message = e.getBindingResult().getFieldErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(","));
		return new ResponseEntity<String>(message,HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> exceptionaHandler(CustomerNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FoodItemNotFoundException.class)
	public ResponseEntity<String> exceptionaHandler(FoodItemNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> exceptionaHandler(OrderNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> exceptionaHandler(UsernameNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> exceptionaHandler(BadCredentialsException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
