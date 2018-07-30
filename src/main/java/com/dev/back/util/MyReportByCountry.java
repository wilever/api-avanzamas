package com.dev.back.util;

public class MyReportByCountry {

	private final String country;
	
	private final Long quantity;
	
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
