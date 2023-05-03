package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HotelManageDAO;
import com.example.demo.dto.hotel_manage;

@Service
public class HotelManageService {
	@Autowired
	HotelManageDAO hotelManageDAO;

	public List<HotelManage> listarHotelManage() {
		return hotelManageDAO.findAll();
	}

	public HotelManage guardarHotelManage(HotelManage hotelManage) {
		return hotelManageDAO.save(hotelManage);
	}

	public HotelManage hotelManageXID(Long id) {
		return hotelManageDAO.findById(id).get();
	}

	public HotelManage actualizarHotelManage(HotelManage hotelManage) {
		return hotelManageDAO.save(hotelManage);
	}

	public void eliminarHotelManage(int id) {
		hotelManageDAO.deleteById(id);
	}
}
