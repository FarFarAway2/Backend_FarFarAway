package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HotelOffer;
import com.example.demo.service.HotelOfferService;

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
	public HotelOffer actualizarHotelOffer(@PathVariable(name = "id") Long id, @RequestBody HotelOffer hotelOffer) {

		HotelOffer hotelOfferSeleccionado = new HotelOffer();
		HotelOffer hotelOfferActualizado = new HotelOffer();

		hotelOfferSeleccionado = hotelOfferService.hotelOfferXID(id);
		hotelOfferSeleccionado.setId_hotel(hotelOffer.getId_hotel());
		hotelOfferSeleccionado.setPrice(hotelOffer.getPrice());
		hotelOfferSeleccionado.setRating(hotelOffer.getRating());
		hotelOfferSeleccionado.setImage(hotelOffer.getImage());
		hotelOfferSeleccionado.setExpire_date(hotelOffer.getExpire_date());
		hotelOfferSeleccionado.setLongitude(hotelOffer.getLongitude());
		hotelOfferSeleccionado.setLatitude(hotelOffer.getLatitude());
		hotelOfferSeleccionado.setLocation(hotelOffer.getLocation());
		hotelOfferSeleccionado.setHotel_name(hotelOffer.getHotel_name());
		hotelOfferSeleccionado.setTitle(hotelOffer.getTitle());

		hotelOfferActualizado = hotelOfferService.updateHotelOffer(hotelOfferSeleccionado);

		return hotelOfferActualizado;
	}

	@DeleteMapping("/hoteloffers/{id}")
	public void eliminarHotelOffer(@PathVariable(name = "id") Long id) {
		hotelOfferService.deleteHotelOffer(id);
	}
}
