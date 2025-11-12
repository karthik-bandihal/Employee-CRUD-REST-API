package com.jsp.REST.Error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.REST.dto.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DataExistsException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ErrorDto handle(DataExistsException exception) {
		return new ErrorDto(exception.getMessage());
		
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ErrorDto handle(DataNotFoundException exception) {
		return new ErrorDto(exception.getMessage());
		
	}
}