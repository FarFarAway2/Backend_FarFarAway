package com.farfaraway.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farfaraway.app.dao.ITravelOfferDAO;
import com.farfaraway.app.dto.TravelOffer;

@Service
public class TravelOfferService {
	@Autowired
	ITravelOfferDAO iTravelOfferDAO;

	public List<TravelOffer> listTravelOffers() {
		return iTravelOfferDAO.findAll();
	}

	public TravelOffer saveTravelOffer(TravelOffer travelOffer) {
		return iTravelOfferDAO.save(travelOffer);
	}

	public TravelOffer travelOfferXID(Long id) {
		return iTravelOfferDAO.findById(id).get();
	}

	public TravelOffer updateTravelOffer(TravelOffer travelOffer) {
		return iTravelOfferDAO.save(travelOffer);
	}

	public void deleteTravelOffer(Long id) {
		iTravelOfferDAO.deleteById(id);
	}

	public List<TravelOffer> findByTheme(List<String> themes) {
		return iTravelOfferDAO.findByTravelTypeIn(themes);
	}

	public List<TravelOffer> findByPrice(Long priceLow, Long priceTop) {
		return iTravelOfferDAO.findByPriceBetween(priceLow, priceTop);
	}

	public List<TravelOffer> findByExpireDate(LocalDate dateStart, LocalDate dateEnd) {
		return iTravelOfferDAO.findByExpireDateBetween(dateStart, dateEnd);
	}

	public List<TravelOffer> findByDestination(String destination) {
		return iTravelOfferDAO.findByDestination(destination);
	}
	
	public List<TravelOffer> findByStartDateBetween(LocalDate dateStart, LocalDate dateEnd) {
		return iTravelOfferDAO.findByStartDateBetween(dateStart, dateEnd);
	}
}
