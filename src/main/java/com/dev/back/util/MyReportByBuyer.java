package com.dev.back.util;

public class MyReportByBuyer {

	private final String buyer;
	
	private final Long quantity;
	
	private final Double earnings;

	public MyReportByBuyer(String buyer, Long quantity, Double earnings) {
		
		this.buyer = buyer;
		this.quantity = quantity;
		this.earnings = earnings;
	}

	public String getBuyer() {
		return buyer;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Double getEarnings() {
		return earnings;
	}
	
	
}
