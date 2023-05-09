package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HotelBook;
import com.example.demo.service.HotelBookService;

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

		HotelBook hotelBookSeleccionado = new HotelBook();
		HotelBook hotelBookActualizado = new HotelBook();

		hotelBookSeleccionado = hotelBookService.hotelBookXID(id);
		;
		hotelBookSeleccionado.setId_user(hotelBook.getId_user());
		hotelBookSeleccionado.setId_hotel(hotelBook.getId_hotel());

		hotelBookActualizado = hotelBookService.updateHotelBook(hotelBookSeleccionado);

		return hotelBookActualizado;
	}

	@DeleteMapping("/hotelbooks/{id}")
	public void deleteHotelBook(@PathVariable(name = "id") Long id) {
		hotelBookService.deleteHotelBook(id);
	}
}
