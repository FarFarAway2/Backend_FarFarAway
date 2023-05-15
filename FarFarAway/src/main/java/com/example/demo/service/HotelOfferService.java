package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IHotelOfferDAO;
import com.example.demo.dto.HotelOffer;

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
}

