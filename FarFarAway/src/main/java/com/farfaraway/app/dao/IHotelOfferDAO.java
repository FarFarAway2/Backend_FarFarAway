package com.farfaraway.app.dao;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.HotelOffer;

public interface IHotelOfferDAO extends JpaRepository<HotelOffer, Long>{
	List<HotelOffer> findByRatingIn(List<Long> ratings);
	List<HotelOffer> findByPriceBetween(Long priceLow, Long priceTop);
	List<HotelOffer> findByExpireDateBetween(LocalDate dateStart, LocalDate dateEnd);
	List<HotelOffer> findByLocation(String location);
	List<HotelOffer> findByStartDateBetween(LocalDate dateStart, LocalDate dateEnd);
}
