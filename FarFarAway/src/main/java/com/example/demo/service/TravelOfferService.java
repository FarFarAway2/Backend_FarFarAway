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

	public List<TravelOffer> listTravelOffers() {
		return travelOfferDAO.findAll();
	}

	public TravelOffer saveTravelOffer(TravelOffer travelOffer) {
		return travelOfferDAO.save(travelOffer);
	}

	public TravelOffer travelOfferXID(Long id) {
		return travelOfferDAO.findById(id).get();
	}

	public TravelOffer updateTravelOffer(TravelOffer travelOffer) {
		return travelOfferDAO.save(travelOffer);
	}

	public void deleteTravelOffer(Long id) {
		travelOfferDAO.deleteById(id);
	}
}
