package com.dev.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.back.entity.Country;
import com.dev.back.repository.CountryRepo;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepo repo;
	
	public List<Country> getCountries(){
		return repo.findAll();
	}
}
