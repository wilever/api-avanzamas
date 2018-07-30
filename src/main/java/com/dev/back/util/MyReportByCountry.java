package com.dev.back.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Reporte de ventas por país")
public class MyReportByCountry {

	@ApiModelProperty(value="País mostrado",required=true)
	private final String country;
	
	@ApiModelProperty(value="Cantidad de unidades vendidas por país",required=true)
	private final Long quantity;
	
	@ApiModelProperty(value="Ganancias obtenidas por país",required=true)
	private final Double earnings;

	public MyReportByCountry(String country, Long quantity, Double earnings) {
		
		this.country = country;
		this.quantity = quantity;
		this.earnings = earnings;
	}

	public String getCountry() {
		return country;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Double getEarnings() {
		return earnings;
	}
	
	
}
