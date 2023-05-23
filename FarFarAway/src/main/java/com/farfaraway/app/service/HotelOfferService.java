package com.farfaraway.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farfaraway.app.dao.IHotelOfferDAO;
import com.farfaraway.app.dto.HotelOffer;

@Service
public class HotelOfferService {
	@Autowired
	IHotelOfferDAO ihotelOfferDAO;

	public List<HotelOffer> listHotelOffers() {
		return ihotelOfferDAO.findAll();
	}

	public HotelOffer saveHotelOffer(HotelOffer hotelOffer) {
		return ihotelOfferDAO.save(hotelOffer);
	}

	public HotelOffer hotelOfferXID(Long id) {
		return ihotelOfferDAO.findById(id).get();
	}

	public HotelOffer updateHotelOffer(HotelOffer hotelOffer) {
		return ihotelOfferDAO.save(hotelOffer);
	}

	public void deleteHotelOffer(Long id) {
		ihotelOfferDAO.deleteById(id);
	}

	public List<HotelOffer> findByRating(List<Long> ratings) {
		return ihotelOfferDAO.findByRatingIn(ratings);
	}
	
	public List<HotelOffer> findByPrice(Long priceLow, Long priceTop) {
		return ihotelOfferDAO.findByPriceBetween(priceLow, priceTop);
	}
	
	public List<HotelOffer> findByExpireDate(LocalDate dateStart, LocalDate dateEnd) {
		return ihotelOfferDAO.findByExpireDateBetween(dateStart, dateEnd);
	}
}

