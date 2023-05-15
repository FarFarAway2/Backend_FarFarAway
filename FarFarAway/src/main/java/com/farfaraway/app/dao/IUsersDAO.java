package com.farfaraway.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.Users;

public interface IUsersDAO extends JpaRepository<Users, Long>{

}
