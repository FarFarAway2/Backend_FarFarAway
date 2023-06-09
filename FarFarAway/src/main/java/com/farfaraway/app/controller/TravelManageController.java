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

import com.farfaraway.app.dto.TravelManage;
import com.farfaraway.app.service.TravelManageService;

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
		TravelManage travelManageSelected = new TravelManage();
		TravelManage travelManageUpdated = new TravelManage();

		travelManageSelected = travelManageService.travelManageXID(id);
		travelManageSelected.setId_user(travelManage.getId_user());
		travelManageSelected.setId_travel(travelManage.getId_travel());

		travelManageUpdated = travelManageService.updateTravelManage(travelManageSelected);

		return travelManageUpdated;
	}

	@DeleteMapping("/travelmanages/{id}")
	public void deleteTravelManage(@PathVariable(name = "id") Long id) {
		travelManageService.deleteTravelManage(id);
	}
}
