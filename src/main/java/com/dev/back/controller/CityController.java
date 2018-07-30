package com.dev.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.back.entity.City;
import com.dev.back.entity.Sale;
import com.dev.back.service.CityService;
import com.dev.back.util.HandlerException.MyHandlerResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller for {@link Sale}.
 * It provide CRUD operations over entity.
 * 
 * @author Wilever Gomez [wilevergomez@gmail.com]
 * 
 */
@Api(tags= {"City Controller"},
description="Show data of table \"CIUDADES\"")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/city")
@RestController
public class CityController {

	@Autowired
	private CityService service;
	
	@ApiOperation(
			value= "Get data",
			notes= "Get data from database")
	@ApiResponses(value= {
			@ApiResponse(
					code= 204,
					message = "No content available"),
			@ApiResponse(
					code= 200, 
					response= City.class, 
					message = "Data from database"),
			@ApiResponse(
					code= 500, 
					response= MyHandlerResponse.class, 
					message = "Server error")
	})
	@GetMapping("")
	public ResponseEntity<List<City>> get(){
		return service.get();
	}
}
