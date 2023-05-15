package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IHotelManageDAO;
import com.example.demo.dto.HotelManage;

@Service
public class HotelManageService {
	@Autowired
	IHotelManageDAO ihotelManageDAO;

	public List<HotelManage> listHotelManage() {
		return ihotelManageDAO.findAll();
	}

	public HotelManage saveHotelManage(HotelManage hotelManage) {
		return ihotelManageDAO.save(hotelManage);
	}

	public HotelManage hotelManageXID(Long id) {
		return ihotelManageDAO.findById(id).get();
	}

	public HotelManage updateHotelManage(HotelManage hotelManage) {
		return ihotelManageDAO.save(hotelManage);
	}

	public void deleteHotelManage(Long id) {
		ihotelManageDAO.deleteById(id);
	}
}
