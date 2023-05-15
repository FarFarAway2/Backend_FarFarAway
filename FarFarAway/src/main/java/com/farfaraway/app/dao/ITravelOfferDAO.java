package com.farfaraway.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.TravelOffer;

public interface ITravelOfferDAO extends JpaRepository<TravelOffer, Long>{

}
