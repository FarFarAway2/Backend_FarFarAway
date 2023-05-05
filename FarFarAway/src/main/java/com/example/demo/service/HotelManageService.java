package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IHotelManageDAO;
import com.example.demo.dto.HotelManage;
import com.example.demo.dto.Users;

@Service
public class HotelManageService {
	@Autowired
	IHotelManageDAO hotelManageDAO;

	public List<HotelManage> listHotelManage() {
		return hotelManageDAO.findAll();
	}

	public HotelManage saveHotelManage(HotelManage hotelManage) {
		return hotelManageDAO.save(hotelManage);
	}

	public HotelManage hotelManageXID(Users id) {
		return hotelManageDAO.findById(id).get();
	}

	public HotelManage updateHotelManage(HotelManage hotelManage) {
		return hotelManageDAO.save(hotelManage);
	}

	public void deleteHotelManage(Users id) {
		hotelManageDAO.deleteById(id);
	}
}
