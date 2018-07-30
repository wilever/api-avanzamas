package com.dev.back.util;

import com.dev.back.entity.User;

public class MyApiResponse {
	
	private final message message;
	
	private final User data;

	public MyApiResponse(message message, User data) {
		this.message = message;
		this.data = data;
	}

	public message getMessage() {
		return message;
	}

	public User getData() {
		return data;
	}
	
	public enum message{
		DATA_SAVED,
		DATA_DELETED,
		DATA_UPDATED,
		DATA_NO_EXIST,
		DATA_ALREADY_EXIST;
	}

	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", data=" + data + "]";
	}
}
