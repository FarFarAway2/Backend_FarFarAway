package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IHotelOfferDAO;
import com.example.demo.dto.HotelOffer;

@Service
public class HotelOfferService {
	@Autowired
	IHotelOfferDAO hotelOfferDAO;

	public List<HotelOffer> listHotelOffers() {
		return hotelOfferDAO.findAll();
	}

	public HotelOffer saveHotelOffer(HotelOffer hotelOffer) {
		return hotelOfferDAO.save(hotelOffer);
	}

	public HotelOffer hotelOfferXID(Long id) {
		return hotelOfferDAO.findById(id).get();
	}

	public HotelOffer updateHotelOffer(HotelOffer hotelOffer) {
		return hotelOfferDAO.save(hotelOffer);
	}

	public void deleteHotelOffer(Long id) {
		hotelOfferDAO.deleteById(id);
	}
}

