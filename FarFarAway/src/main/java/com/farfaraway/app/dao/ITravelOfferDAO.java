package com.farfaraway.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.TravelOffer;

public interface ITravelOfferDAO extends JpaRepository<TravelOffer, Long>{
	List<TravelOffer> findByTravelTypeIn(List<String> themes);
	List<TravelOffer> findByPriceBetween(Long priceLow, Long priceTop);
	List<TravelOffer> findByExpireDateBetween(LocalDate dateStart, LocalDate dateEnd);
	List<TravelOffer> findByDestination(String destination);
	List<TravelOffer> findByStartDateBetween(LocalDate dateStart, LocalDate dateEnd);
}
