package com.farfaraway.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farfaraway.app.dto.TravelOffer;
import com.farfaraway.app.service.TravelOfferService;

@RestController
public class TravelOfferController {

	@Autowired
	TravelOfferService travelOfferService;

	@GetMapping("/traveloffers")
	public List<TravelOffer> listTravelOffers() {
		return travelOfferService.listTravelOffers();
	}

	@PostMapping("/traveloffers")
	public TravelOffer saveTravelOffer(@RequestBody TravelOffer travelOffer) {
		return travelOfferService.saveTravelOffer(travelOffer);
	}

	@GetMapping("/traveloffers/{id}")
	public TravelOffer travelOfferXID(@PathVariable(name = "id") Long id) {
		return travelOfferService.travelOfferXID(id);
	}

	@PutMapping("/traveloffers/{id}")
	public TravelOffer updateTravelOffer(@PathVariable(name = "id") Long id, @RequestBody TravelOffer travelOffer) {
		TravelOffer travelOfferSelected = new TravelOffer();
		TravelOffer travelOfferUpdated = new TravelOffer();

		travelOfferSelected = travelOfferService.travelOfferXID(id);
		travelOfferSelected.setPrice(travelOffer.getPrice());
		travelOfferSelected.setImage(travelOffer.getImage());
		travelOfferSelected.setTravel_Description(travelOffer.getTravel_Description());
		travelOfferSelected.setTravel_name(travelOffer.getTravel_name());
		travelOfferSelected.setTransport(travelOffer.getTransport());
		travelOfferSelected.setExpire_date(travelOffer.getExpire_date());
		travelOfferSelected.setTravel_type(travelOffer.getTravel_type());
		travelOfferSelected.setTitle(travelOffer.getTitle());
		travelOfferSelected.setTravel_active(travelOffer.getTravel_active());
		travelOfferSelected.setId_user(travelOffer.getId_user());

		travelOfferUpdated = travelOfferService.updateTravelOffer(travelOfferSelected);

		return travelOfferUpdated;
	}

	@DeleteMapping("/traveloffers/{id}")
	public void deleteTravelOffer(@PathVariable(name = "id") Long id) {
		travelOfferService.deleteTravelOffer(id);
	}
	
	@GetMapping("/traveloffers/theme/{themes}")
	public List<TravelOffer> findByRating(@PathVariable(name = "themes") List<String> themes) {
		return travelOfferService.findByTheme(themes);
	}
	
	@GetMapping("/traveloffers/price/{prices}")
	public List<TravelOffer> findByPrice(@PathVariable(name = "prices") List<Long> prices) {
		return travelOfferService.findByPrice(prices.get(0), prices.get(1));
	}
	
	@GetMapping("/traveloffers/expiredate")
	public List<TravelOffer> findByExpireDate() {
		return travelOfferService.findByExpireDate(LocalDate.now(), LocalDate.now().plusWeeks(1));
	}
	
	@GetMapping("/traveloffers/destination/{destination}")
	public List<TravelOffer> findByDestination(@PathVariable(name = "destination") String destination) {
		return travelOfferService.findByDestination(destination);
	}
	
	@GetMapping("/traveloffers/startdate")
	public List<TravelOffer> findByStartDate() {
		return travelOfferService.findByStartDateBetween(LocalDate.now(), LocalDate.now().plusWeeks(1));
	}
}
