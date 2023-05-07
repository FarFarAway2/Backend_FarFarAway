package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.TravelBook;
import com.example.demo.dto.Users;

public interface ITravelBookDAO extends JpaRepository<TravelBook, Long> {

}
