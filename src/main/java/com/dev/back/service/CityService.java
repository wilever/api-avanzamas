package com.dev.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.back.entity.City;
import com.dev.back.repository.CityRepo;

@Service
public class CityService {
	
	@Autowired
	private CityRepo repo;
	
	public ResponseEntity<List<City>> get(){
		List<City> cities = repo.findAll();
		if (cities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(
						cities
						, HttpStatus.OK);
		}
	}
}
