package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.UserRole;
import com.example.demo.dto.Users;

public interface IUserRoleDAO extends JpaRepository<UserRole, Long>{

}
