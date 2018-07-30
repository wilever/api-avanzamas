package com.dev.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.back.entity.Buyer;
import com.dev.back.repository.BuyerRepo;

@Service
public class BuyerService {
	
	@Autowired
	private BuyerRepo repo;
	
	public ResponseEntity<List<Buyer>> get(){
		List<Buyer> buyers = repo.findAll();
		if (buyers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(
						buyers
						, HttpStatus.OK);
		}
	}
}
