package com.dev.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.back.entity.User;
import com.dev.back.service.UserService;
import com.dev.back.util.HandlerException.MyHandlerResponse;
import com.dev.back.util.MyApiException;
import com.dev.back.util.MyApiResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller for {@link User}.
 * It provide CRUD operations over entity.
 * 
 * @author Wilever Gomez [wilevergomez@gmail.com]
 * 
 */
@Api(tags= {"User Controller"},
description="CRUD operation over table \"USUARIOS\"")
@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/user")
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@ApiOperation(
			value= "Get data",
			notes= "Get data from database")
	@ApiResponses(value= {
			@ApiResponse(
					code= 204,
					message = "No content available"),
			@ApiResponse(
					code= 200, 
					response= User.class, 
					message = "Data from database"),
			@ApiResponse(
					code= 500, 
					response= MyHandlerResponse.class, 
					message = "Server error")
	})
	@GetMapping("")
	public ResponseEntity<List<User>> get(){
		return service.get();
	}
	
	@ApiOperation(
			value= "Add new data",
			notes= "Add new data to database")
	@ApiResponses(value= {
			@ApiResponse(
					code= 200, 
					response= MyApiResponse.class, 
					message = "New data created"),
			@ApiResponse(
					code= 409, 
					response= MyHandlerResponse.class, 
					message = "Id already exist"),
			@ApiResponse(
					code= 500, 
					response= MyHandlerResponse.class, 
					message = "Server error")
	})
	@PostMapping("")
	public ResponseEntity<MyApiResponse> post(
			@RequestBody
			User data) throws MyApiException{
		return service.post(data);
	}
	
	@ApiOperation(
			value= "Update data",
			notes= "Update data on database")
	@ApiResponses(value= {
			@ApiResponse(
					code= 200, 
					response= MyApiResponse.class, 
					message = "Data updated"),
			@ApiResponse(
					code= 409, 
					response= MyHandlerResponse.class, 
					message = "Data with conflic"),
			@ApiResponse(
					code= 500, 
					response= MyHandlerResponse.class, 
					message = "Id no exist")
	})
	@PutMapping("")
	public ResponseEntity<MyApiResponse> put(
			@RequestParam("id")
			Long id,
			@RequestBody
			User data) throws MyApiException{
		return service.put(id, data);
	}
	
	@ApiOperation(
			value= "Delete data",
			notes= "Delete data on database")
	@ApiResponses(value= {
			@ApiResponse(
					code= 200, 
					response= MyApiResponse.class, 
					message = "Data deleted"),
			@ApiResponse(
					code= 409, 
					response= MyHandlerResponse.class, 
					message = "Id no exist"),
			@ApiResponse(
					code= 500, 
					response= MyHandlerResponse.class, 
					message = "Server error")
	})
	@DeleteMapping("")
	public ResponseEntity<MyApiResponse> delete(
			@RequestParam("id")
			Long id) throws MyApiException{
		return service.delete(id);
	}
}
