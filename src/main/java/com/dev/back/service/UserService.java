package com.dev.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.back.entity.User;
import com.dev.back.repository.UserRepo;
import com.dev.back.util.MyApiException;
import com.dev.back.util.MyApiResponse;
import com.dev.back.util.MyApiResponse.message;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public ResponseEntity<List<User>> get(){
		List<User> users = repo.findAll(); 
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(
						users
						, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<MyApiResponse> post(User data) throws MyApiException {
		if (repo.findOne(data.getId())!=null) {
			throw new MyApiException(message.DATA_ALREADY_EXIST);
		}else {
			repo.save(data);
			return new ResponseEntity<>(
						new MyApiResponse(
								message.DATA_SAVED, data)
					, HttpStatus.CREATED);
		}
	}
	
	public ResponseEntity<MyApiResponse> put(Long id, User data) throws MyApiException {
		if (repo.findOne(id)==null) {
			throw new MyApiException(message.DATA_NO_EXIST);
		}else {
			data.setId(id);
			repo.save(data);
			return new ResponseEntity<>(
						new MyApiResponse(
								message.DATA_SAVED, data)
						, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<MyApiResponse> delete(Long id) throws MyApiException {
		if (repo.findOne(id)==null) {
			throw new MyApiException(message.DATA_NO_EXIST);
		}else {
			repo.delete(id);
			return new ResponseEntity<>(
						new MyApiResponse(
								message.DATA_DELETED, null)
					, HttpStatus.OK);
		}
	}
}
