package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.HotelOfferDAO;
import com.example.demo.dto.hotel_offer;

@Service
public class HotelOfferService {
	@Autowired
	HotelOfferDAO hotelOfferDAO;

	public List<HotelOffers> listarHotelOffers() {
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

	public void eliminarHotelOffer(int id) {
		hotelOfferDAO.deleteById(id);
	}
}

