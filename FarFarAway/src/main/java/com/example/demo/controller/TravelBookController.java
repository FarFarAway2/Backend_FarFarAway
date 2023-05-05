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

import com.example.demo.dto.TravelBook;
import com.example.demo.dto.Users;
import com.example.demo.service.TravelBookService;

@RestController
public class TravelBookController {

	@Autowired
	TravelBookService travelBookService;

	@GetMapping("/travelbook")
	public List<TravelBook> listTravelBooks() {
		return travelBookService.listTravelBooks();
	}

	@PostMapping("/travelbook")
	public TravelBook saveTravelBook(@RequestBody TravelBook travelBook) {
		return travelBookService.saveTravelBook(travelBook);
	}

	@GetMapping("/travelbook/{id}")
	public TravelBook travelBookXID(@PathVariable(name = "id") Users id) {
		return travelBookService.travelBookXID(id);
	}

	@PutMapping("/travelbook/{id}")
	public TravelBook actualizarTravelBook(@PathVariable(name = "id") Users id, @RequestBody TravelBook travelBook) {

		TravelBook travelBookSeleccionado = new TravelBook();
		TravelBook travelBookActualizado = new TravelBook();

		travelBookSeleccionado = travelBookService.travelBookXID(id);
		travelBookSeleccionado.setId_user(travelBook.getId_user());
		travelBookSeleccionado.setId_travel(travelBook.getId_travel());

		travelBookActualizado = travelBookService.updateTravelBook(travelBookSeleccionado);

		return travelBookActualizado;
	}

	@DeleteMapping("/travelbook/{id}")
	public void eliminarTravelBook(@PathVariable(name = "id") Users id) {
		travelBookService.deleteTravelBook(id);
	}
}
