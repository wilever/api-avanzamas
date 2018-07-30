package com.dev.back.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<MyHandlerResponse> defaultException(
    		final Exception exception) {
		
		return new ResponseEntity<>(
				new MyHandlerResponse(
						exception.getMessage()), 
			null, 
			HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	@ExceptionHandler(MyApiException.class)
    public ResponseEntity<MyHandlerResponse> myException(
    		final MyApiException exception) {
		return new ResponseEntity<>(
				new MyHandlerResponse(
						exception.getMessage()), 
			null, 
			HttpStatus.CONFLICT);
		}
	
	@ApiModel("Respuesta en caso de error")
	public class MyHandlerResponse {

		@ApiModelProperty(value="Message del error")
		private final String message;

		public MyHandlerResponse(String message) {
			
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
}
