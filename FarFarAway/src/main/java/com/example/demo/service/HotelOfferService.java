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

	public List<HotelOffer> listarHotelOffers() {
		return hotelOfferDAO.findAll();
	}

	public HotelOffer guardarHotelOffer(HotelOffer hotelOffer) {
		return hotelOfferDAO.save(hotelOffer);
	}

	public HotelOffer hotelOfferXID(Long id) {
		return hotelOfferDAO.findById(id).get();
	}

	public HotelOffer actualizarHotelOffer(HotelOffer hotelOffer) {
		return hotelOfferDAO.save(hotelOffer);
	}

	public void eliminarHotelOffer(Long id) {
		hotelOfferDAO.deleteById(id);
	}
}

