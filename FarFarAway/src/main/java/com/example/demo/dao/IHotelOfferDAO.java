package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.HotelOffer;

public interface IHotelOfferDAO extends JpaRepository<HotelOffer, Long>{

}
