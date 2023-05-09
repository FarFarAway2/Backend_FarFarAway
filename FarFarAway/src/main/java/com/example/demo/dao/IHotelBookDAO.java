package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.HotelBook;

public interface IHotelBookDAO extends JpaRepository<HotelBook, Long>{

}