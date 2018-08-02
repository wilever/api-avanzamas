package com.dev.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.back.entity.Buyer;
import com.dev.back.entity.Sale;
import com.dev.back.service.BuyerService;
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
@Api(tags= {"Buyer Controller"},
description="Show data of table \"COMPRADORES\"")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/buyer")
@RestController
public class BuyerController {

	@Autowired
	private BuyerService service;
	
	@ApiOperation(
			value= "Get data",
			notes= "Get data from database")
	@ApiResponses(value= {
			@ApiResponse(
					code= 204,
					message = "No content available"),
			@ApiResponse(
					code= 200, 
					response= Buyer.class, 
					message = "Data from database"),
			@ApiResponse(
					code= 500, 
					response= MyHandlerResponse.class, 
					message = "Server error")
	})
	@GetMapping("")
	public ResponseEntity<List<Buyer>> get(){
		return service.get();
	}
}
