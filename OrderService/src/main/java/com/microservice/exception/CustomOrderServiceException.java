package com.microservice.exception;

import lombok.Data;

@Data
public class CustomOrderServiceException extends Exception{

	
	private String errorCode;
	public CustomOrderServiceException(String message,String errorCode)
	{
		super(message);
		this.errorCode = errorCode;
	}
}
