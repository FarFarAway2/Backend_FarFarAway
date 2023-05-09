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

import com.example.demo.dto.TravelManage;
import com.example.demo.service.TravelManageService;

@RestController
public class TravelManageController {

	@Autowired
	TravelManageService travelManageService;

	@GetMapping("/travelmanages")
	public List<TravelManage> listTravelManages() {
		return travelManageService.listTravelManage();
	}

	@PostMapping("/travelmanages")
	public TravelManage saveTravelManage(@RequestBody TravelManage travelManage) {
		return travelManageService.saveTravelManage(travelManage);
	}

	@GetMapping("/travelmanages/{id}")
	public TravelManage travelManageXID(@PathVariable(name = "id") Long id) {
		return travelManageService.travelManageXID(id);
	}

	@PutMapping("/travelmanages/{id}")
	public TravelManage updateTravelManage(@PathVariable(name = "id") Long id,
			@RequestBody TravelManage travelManage) {

		TravelManage travelManageSeleccionado = new TravelManage();
		TravelManage travelManageActualizado = new TravelManage();

		travelManageSeleccionado = travelManageService.travelManageXID(id);
		travelManageSeleccionado.setId_user(travelManage.getId_user());
		travelManageSeleccionado.setId_travel(travelManage.getId_travel());

		travelManageActualizado = travelManageService.updateTravelManage(travelManageSeleccionado);

		return travelManageActualizado;
	}

	@DeleteMapping("/travelmanages/{id}")
	public void deleteTravelManage(@PathVariable(name = "id") Long id) {
		travelManageService.deleteTravelManage(id);
	}
}
