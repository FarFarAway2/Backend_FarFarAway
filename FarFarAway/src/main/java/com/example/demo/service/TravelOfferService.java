package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.TravelOfferDAO;
import com.example.demo.dto.travel_offer;

@Service
public class TravelOfferService {
	@Autowired
	TravelOfferDAO travelOfferDAO;

	public List<TravelOffers> listarTravelOffers() {
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

	public void eliminarTravelOffer(int id) {
		travelOfferDAO.deleteById(id);
	}
}
