package com.farfaraway.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.UserRole;

public interface IUserRoleDAO extends JpaRepository<UserRole, Long>{

}
