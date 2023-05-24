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

import com.farfaraway.app.dto.HotelOffer;
import com.farfaraway.app.service.HotelOfferService;

@RestController
public class HotelOfferController {

	@Autowired
	HotelOfferService hotelOfferService;

	@GetMapping("/hoteloffers")
	public List<HotelOffer> listHotelOffers() {
		return hotelOfferService.listHotelOffers();
	}

	@PostMapping("/hoteloffers")
	public HotelOffer saveHotelOffer(@RequestBody HotelOffer hotelOffer) {
		return hotelOfferService.saveHotelOffer(hotelOffer);
	}

	@GetMapping("/hoteloffers/{id}")
	public HotelOffer hotelOfferXID(@PathVariable(name = "id") Long id) {
		return hotelOfferService.hotelOfferXID(id);
	}

	@PutMapping("/hoteloffers/{id}")
	public HotelOffer updateHotelOffer(@PathVariable(name = "id") Long id, @RequestBody HotelOffer hotelOffer) {
		HotelOffer hotelOfferSelected = new HotelOffer();
		HotelOffer hotelOfferUpdated = new HotelOffer();

		hotelOfferSelected = hotelOfferService.hotelOfferXID(id);
		hotelOfferSelected.setPrice(hotelOffer.getPrice());
		hotelOfferSelected.setRating(hotelOffer.getRating());
		hotelOfferSelected.setImage(hotelOffer.getImage());
		hotelOfferSelected.setExpire_date(hotelOffer.getExpire_date());
		hotelOfferSelected.setLongitude(hotelOffer.getLongitude());
		hotelOfferSelected.setLatitude(hotelOffer.getLatitude());
		hotelOfferSelected.setLocation(hotelOffer.getLocation());
		hotelOfferSelected.setHotel_name(hotelOffer.getHotel_name());
		hotelOfferSelected.setTitle(hotelOffer.getTitle());
		hotelOfferSelected.setHotel_active(hotelOffer.getHotel_active());
		hotelOfferSelected.setId_user(hotelOffer.getId_user());

		hotelOfferUpdated = hotelOfferService.updateHotelOffer(hotelOfferSelected);

		return hotelOfferUpdated;
	}

	@DeleteMapping("/hoteloffers/{id}")
	public void deleteHotelOffer(@PathVariable(name = "id") Long id) {
		hotelOfferService.deleteHotelOffer(id);
	}
	
	@GetMapping("/hoteloffers/rating/{ratings}")
	public List<HotelOffer> findByRating(@PathVariable(name = "ratings") List<Long> ratings) {
		return hotelOfferService.findByRating(ratings);
	}
	
	@GetMapping("/hoteloffers/price/{prices}")
	public List<HotelOffer> findByPrice(@PathVariable(name = "prices") List<Long> prices) {
		return hotelOfferService.findByPrice(prices.get(0), prices.get(1));
	}
	
	@GetMapping("/hoteloffers/expiredate")
	public List<HotelOffer> findByExpireDate() {
		return hotelOfferService.findByExpireDate(LocalDate.now(), LocalDate.now().plusWeeks(1));
	}
	
	@GetMapping("/hoteloffers/location/{location}")
	public List<HotelOffer> findByLocation(@PathVariable(name = "location") String location) {
		return hotelOfferService.findByLocation(location);
	}
	
	@GetMapping("/hoteloffers/startdate")
	public List<HotelOffer> findByStartDate() {
		return hotelOfferService.findByExpireDate(LocalDate.now(), LocalDate.now().plusWeeks(1));
	}
}
