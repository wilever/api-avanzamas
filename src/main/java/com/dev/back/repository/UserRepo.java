package com.dev.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.back.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
