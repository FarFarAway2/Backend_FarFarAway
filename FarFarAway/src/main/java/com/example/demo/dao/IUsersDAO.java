package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Users;

public interface IUsersDAO extends JpaRepository<Users, Long>{
	
	Users findByEmail(String email);

}
