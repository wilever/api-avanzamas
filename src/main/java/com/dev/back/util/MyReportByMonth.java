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
	
	public enum MyMonth {
		JANUARY,
		FEBRUARY,
		MARCH,
		APRIL,
		MAY,
		JUNE,
		JULY,
		AUGUST,
		SEPTEMBER,
		OCTOBER,
		NOVEMBER,
		DECEMBER;
		
		public static MyMonth fromInteger(int x) {
	        switch(x) {
	        case 1:
	            return JANUARY;
	        case 2:
	            return FEBRUARY;
	        case 3:
	            return MARCH;
	        case 4:
	            return APRIL;
	        case 5:
	            return MAY;
	        case 6:
	            return JUNE;
	        case 7:
	            return JULY;
	        case 8:
	            return AUGUST;
	        case 9:
	            return SEPTEMBER;
	        case 10:
	            return OCTOBER;
	        case 11:
	            return NOVEMBER;
	        case 12:
	            return DECEMBER;
	        }
	        return null;
	    }
	}
}
