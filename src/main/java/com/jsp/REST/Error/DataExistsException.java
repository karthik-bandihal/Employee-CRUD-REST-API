package com.jsp.REST.Error;



import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataExistsException extends RuntimeException {
	private String message;
}