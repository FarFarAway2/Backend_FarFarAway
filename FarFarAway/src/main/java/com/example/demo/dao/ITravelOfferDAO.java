package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.TravelOffer;

public interface ITravelOfferDAO extends JpaRepository<TravelOffer, Long>{

}
