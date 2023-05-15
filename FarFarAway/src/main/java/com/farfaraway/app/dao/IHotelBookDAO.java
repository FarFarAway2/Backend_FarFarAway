package com.farfaraway.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.HotelBook;

public interface IHotelBookDAO extends JpaRepository<HotelBook, Long>{

}