package com.dev.back.util;

import com.dev.back.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Respuesta de operaciones CRUD")
public class MyApiResponse {
	
	@ApiModelProperty(value="Mensaje de la operación")
	private final message message;
	
	@ApiModelProperty(value="Datos gestionados o detectados por el servidor")
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
