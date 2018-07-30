package com.dev.back.util;

public class MyReportByMonth {

	private final MyMonth month;
	
	private final Long quantity;
	
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
