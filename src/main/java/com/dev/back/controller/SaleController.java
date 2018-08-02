package com.dev.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.back.entity.Sale;
import com.dev.back.service.SaleService;
import com.dev.back.util.SaleResponse;
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
@Api(tags= {"Sale Controller"},
description="Show data of table \"VENTAS\"")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/sale")
@RestController
public class SaleController {

	@Autowired
	private SaleService service;

	@ApiOperation(
			value= "Get data",
			notes= "Get sale report by: country name, buyer name and by last 6 months from now.")
	@ApiResponses(value= {
			@ApiResponse(
					code= 204,
					message = "No content available"),			
			@ApiResponse(
					code= 200, 
					response= SaleResponse.class, 
					message = "Response can be: Report by last 6 months, Report by country and Sales by Buyer"),
			@ApiResponse(
					code= 500, 
					response= MyHandlerResponse.class, 
					message = "Server error")
	})
	@GetMapping("/report")
	public List<?> report(
			@RequestParam(required=false)
			String country,
			@RequestParam(required=false)
			String buyer) {
		return service.getReport(country, buyer);
	}
}
