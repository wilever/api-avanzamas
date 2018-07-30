package com.dev.back.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Reporte de ventas de los 6 meses previos")
public class MyReportByMonth {

	@ApiModelProperty(value="Mes",required=true)
	private final MyMonth month;
	
	@ApiModelProperty(value="Cantidad de unidades vendidas por mes",required=true)
	private final Long quantity;
	
	@ApiModelProperty(value="Ganancia obtenida por mes",required=true)
	private final Double earnings;

	public MyReportByMonth(int month, Long quantity, Double earnings) {
		
		this.month = MyMonth.fromInteger(month);
		this.quantity = quantity;
		this.earnings = earnings;
	}

	public MyMonth getMonth() {
		return month;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Double getEarnings() {
		return earnings;
	}
	
	
}
