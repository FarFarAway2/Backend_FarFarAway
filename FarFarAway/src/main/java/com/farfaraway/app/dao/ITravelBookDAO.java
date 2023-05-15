package com.farfaraway.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.TravelBook;

public interface ITravelBookDAO extends JpaRepository<TravelBook, Long> {

}
