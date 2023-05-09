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

import com.example.demo.dto.HotelManage;
import com.example.demo.service.HotelManageService;

@RestController
public class HotelManageController {

	@Autowired
	HotelManageService hotelManageService;

	@GetMapping("/hotelmanages")
	public List<HotelManage> listHotelManages() {
		return hotelManageService.listHotelManage();
	}

	@PostMapping("/hotelmanages")
	public HotelManage saveHotelManage(@RequestBody HotelManage hotelManage) {
		return hotelManageService.saveHotelManage(hotelManage);
	}

	@GetMapping("/hotelmanages/{id}")
	public HotelManage hotelManageXID(@PathVariable(name = "id") Long id) {
		return hotelManageService.hotelManageXID(id);
	}

	@PutMapping("/hotelmanages/{id}")
	public HotelManage updateHotelManage(@PathVariable(name = "id") Long id,
			@RequestBody HotelManage hotelManage) {

		HotelManage hotelManageSeleccionado = new HotelManage();
		HotelManage hotelManageActualizado = new HotelManage();

		hotelManageSeleccionado = hotelManageService.hotelManageXID(id);
		hotelManageSeleccionado.setId_user(hotelManage.getId_user());
		hotelManageSeleccionado.setId_hotel(hotelManage.getId_hotel());

		hotelManageActualizado = hotelManageService.updateHotelManage(hotelManageSeleccionado);

		return hotelManageActualizado;
	}

	@DeleteMapping("/hotelmanages/{id}")
	public void deleteHotelManage(@PathVariable(name = "id") Long id) {
		hotelManageService.deleteHotelManage(id);
	}
}
