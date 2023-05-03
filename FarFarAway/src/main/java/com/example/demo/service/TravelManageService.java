package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TravelManageDAO;
import com.example.demo.dto.travel_manage;

@Service
public class TravelManageService {
	@Autowired
	TravelManageDAO travelManageDAO;

	public List<TravelManage> listarTravelManage() {
		return travelManageDAO.findAll();
	}

	public TravelManage guardarTravelManage(TravelManage travelManage) {
		return travelManageDAO.save(travelManage);
	}

	public TravelManage travelManageXID(Long id) {
		return travelManageDAO.findById(id).get();
	}

	public TravelManage actualizarTravelManage(TravelManage travelManage) {
		return travelManageDAO.save(travelManage);
	}

	public void eliminarTravelManage(int id) {
		travelManageDAO.deleteById(id);
	}
}
