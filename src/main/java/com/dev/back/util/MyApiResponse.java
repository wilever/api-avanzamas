package com.dev.back.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Respuesta de operaciones CRUD")
public class MyApiResponse {
	
	@ApiModelProperty(value="Mensaje de la operación")
	private final message message;

	public MyApiResponse(message message) {
		this.message = message;
	}

	public message getMessage() {
		return message;
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
		return "ApiResponse [message=" + message + "]";
	}
}
