package com.dev.back.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.back.entity.Sale;
import com.dev.back.repository.SaleRepo;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepo repo;
	
	public ResponseEntity<List<Sale>> get(){
		List<Sale> sales = repo.findAll();
		if (sales.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(
						sales
						, HttpStatus.OK);
		
		}
	}
	@SuppressWarnings("deprecation")
	public List<?> getReport(String country, String buyer){
		if(country!=null&&buyer==null) {
			return repo.getReportByCountry(country);	
		}else if (buyer!=null&&country==null) {
			return repo.findByBuyer_Name(buyer);
		}else {
			 	Date date = new Date();
		        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        String now = sdf.format(date);
		        date.setMonth(date.getMonth()-6);
		        String before = sdf.format(date);
			return repo.getReportByMonth(now, before);
		}
	}
}
