package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITravelOfferDAO;
import com.example.demo.dto.TravelOffer;

@Service
public class TravelOfferService {
	@Autowired
	ITravelOfferDAO travelOfferDAO;

	public List<TravelOffer> listarTravelOffers() {
		return travelOfferDAO.findAll();
	}

	public TravelOffer guardarTravelOffer(TravelOffer travelOffer) {
		return travelOfferDAO.save(travelOffer);
	}

	public TravelOffer travelOfferXID(Long id) {
		return travelOfferDAO.findById(id).get();
	}

	public TravelOffer actualizarTravelOffer(TravelOffer travelOffer) {
		return travelOfferDAO.save(travelOffer);
	}

	public void eliminarTravelOffer(Long id) {
		travelOfferDAO.deleteById(id);
	}
}
