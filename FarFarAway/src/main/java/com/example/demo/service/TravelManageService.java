package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITravelManageDAO;
import com.example.demo.dto.TravelManage;
import com.example.demo.dto.Users;

@Service
public class TravelManageService {
	@Autowired
	ITravelManageDAO travelManageDAO;

	public List<TravelManage> listTravelManage() {
		return travelManageDAO.findAll();
	}

	public TravelManage saveTravelManage(TravelManage travelManage) {
		return travelManageDAO.save(travelManage);
	}

	public TravelManage travelManageXID(Users id) {
		return travelManageDAO.findById(id).get();
	}

	public TravelManage updateTravelManage(TravelManage travelManage) {
		return travelManageDAO.save(travelManage);
	}

	public void deleteTravelManage(Users id) {
		travelManageDAO.deleteById(id);
	}
}
