package com.dev.back.util;


import com.dev.back.util.MyApiResponse.message;

public class MyApiException extends Exception{
	
	private static final long serialVersionUID = 4006675625170772048L;

	private final String message;

	public MyApiException(message message) {
		
		this.message = message.toString();
	}

	public String getMessage() {
		return message;
	}

}
