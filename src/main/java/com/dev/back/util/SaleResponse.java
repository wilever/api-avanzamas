package com.dev.back.util;

import com.dev.back.entity.Sale;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Posibles respuestas")
public class SaleResponse {
	
	@ApiModelProperty(value="Reporte de ventas de los 6 meses previos")
	private final MyReportByMonth reportSemiAnual;
	
	@ApiModelProperty(value= "Reporte de ventas por país")
	private final MyReportByCountry reportByCountry;
	
	@ApiModelProperty(value= "Ventas por comprador")
	private final Sale saleByBuyer;

	public SaleResponse(MyReportByMonth reportSemiAnual, MyReportByCountry reportByCountry, Sale saleByBuyer) {
		
		this.reportSemiAnual = reportSemiAnual;
		this.reportByCountry = reportByCountry;
		this.saleByBuyer = saleByBuyer;
	}

	public MyReportByMonth getReportSemiAnual() {
		return reportSemiAnual;
	}

	public MyReportByCountry getReportByCountry() {
		return reportByCountry;
	}

	public Sale getSaleByBuyer() {
		return saleByBuyer;
	}

}
