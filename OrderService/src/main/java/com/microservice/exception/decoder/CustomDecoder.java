package com.microservice.exception.decoder;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.exception.CustomOrderServiceException;
import com.microservice.exception.ErrorResponse;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomDecoder implements ErrorDecoder {

	public Exception decode(String methodKey, Response response) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			return new CustomOrderServiceException(errorResponse.getMessage(),errorResponse.getErrorCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new CustomOrderServiceException("ServiceInternalException","SERVICE_EXCEPTION");
	}
	
	

}
