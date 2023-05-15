package com.farfaraway.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.HotelOffer;

public interface IHotelOfferDAO extends JpaRepository<HotelOffer, Long>{

}
