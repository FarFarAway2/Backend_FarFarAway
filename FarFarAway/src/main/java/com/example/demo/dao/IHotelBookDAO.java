package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.HotelBook;
import com.example.demo.dto.Users;

public interface IHotelBookDAO extends JpaRepository<HotelBook, Long>{

}