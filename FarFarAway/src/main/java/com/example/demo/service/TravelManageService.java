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

	public List<TravelManage> listarTravelManage() {
		return travelManageDAO.findAll();
	}

	public TravelManage guardarTravelManage(TravelManage travelManage) {
		return travelManageDAO.save(travelManage);
	}

	public TravelManage travelManageXID(Users id) {
		return travelManageDAO.findById(id).get();
	}

	public TravelManage actualizarTravelManage(TravelManage travelManage) {
		return travelManageDAO.save(travelManage);
	}

	public void eliminarTravelManage(Users id) {
		travelManageDAO.deleteById(id);
	}
}
