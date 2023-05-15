package com.farfaraway.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farfaraway.app.dto.HotelBook;
import com.farfaraway.app.service.HotelBookService;

@RestController
public class HotelBookController {

	@Autowired
	HotelBookService hotelBookService;

	@GetMapping("/hotelbooks")
	public List<HotelBook> listHotelBooks() {
		return hotelBookService.listHotelBooks();
	}

	@PostMapping("/hotelbooks")
	public HotelBook saveHotelBook(@RequestBody HotelBook hotelBook) {
		return hotelBookService.saveHotelBook(hotelBook);
	}

	@GetMapping("/hotelbooks/{id}")
	public HotelBook hotelBookXID(@PathVariable(name = "id") Long id) {
		return hotelBookService.hotelBookXID(id);
	}

	@PutMapping("/hotelbooks/{id}")
	public HotelBook updateHotelBook(@PathVariable(name = "id") Long id, @RequestBody HotelBook hotelBook) {
		HotelBook hotelBookSelected = new HotelBook();
		HotelBook hotelBookUpdated = new HotelBook();

		hotelBookSelected = hotelBookService.hotelBookXID(id);
		hotelBookSelected.setId_user(hotelBook.getId_user());
		hotelBookSelected.setId_hotel(hotelBook.getId_hotel());

		hotelBookUpdated = hotelBookService.updateHotelBook(hotelBookSelected);

		return hotelBookUpdated;
	}

	@DeleteMapping("/hotelbooks/{id}")
	public void deleteHotelBook(@PathVariable(name = "id") Long id) {
		hotelBookService.deleteHotelBook(id);
	}
}
