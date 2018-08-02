package com.dev.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.back.entity.Country;
import com.dev.back.entity.Sale;
import com.dev.back.service.CountryService;
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
@Api(tags= {"Country Controller"},
description="Show data of table \"PAISES\"")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/country")
@RestController
public class CountryController {

	@Autowired
	private CountryService service;

	@ApiOperation(
			value= "Get data",
			notes= "Get countries on database ")
	@ApiResponses(value= {
			@ApiResponse(
					code= 204,
					message = "No content available"),			
			@ApiResponse(
					code= 200, 
					response= Country.class, 
					message = "Response can be: Report by last 6 months, Report by country and Sales by Buyer"),
			@ApiResponse(
					code= 500, 
					response= MyHandlerResponse.class, 
					message = "Server error")
	})
	@GetMapping("")
	public List<Country> getCountries() {
		return service.getCountries();
	}
}
