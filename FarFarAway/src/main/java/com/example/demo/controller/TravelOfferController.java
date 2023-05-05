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

import com.example.demo.dto.TravelOffer;
import com.example.demo.service.TravelOfferService;

@RestController
@RequestMapping("/api")
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
	public TravelOffer actualizarTravelOffer(@PathVariable(name = "id") Long id, @RequestBody TravelOffer travelOffer) {

		TravelOffer travelOfferSeleccionado = new TravelOffer();
		TravelOffer travelOfferActualizado = new TravelOffer();

		travelOfferSeleccionado = travelOfferService.travelOfferXID(id);
		travelOfferSeleccionado.setId_travel(travelOffer.getId_travel());
		travelOfferSeleccionado.setPrice(travelOffer.getPrice());
		travelOfferSeleccionado.setImage(travelOffer.getImage());
		travelOfferSeleccionado.setDescription(travelOffer.getDescription());
		travelOfferSeleccionado.setTravel_name(travelOffer.getTravel_name());
		travelOfferSeleccionado.setTransport(travelOffer.getTransport());
		travelOfferSeleccionado.setExpire_date(travelOffer.getExpire_date());
		travelOfferSeleccionado.setTravel_type(travelOffer.getTravel_type());
		travelOfferSeleccionado.setTitle(travelOffer.getTitle());

		travelOfferActualizado = travelOfferService.updateTravelOffer(travelOfferSeleccionado);

		return travelOfferActualizado;
	}

	@DeleteMapping("/traveloffers/{id}")
	public void eliminarTravelOffer(@PathVariable(name = "id") Long id) {
		travelOfferService.deleteTravelOffer(id);
	}
}
