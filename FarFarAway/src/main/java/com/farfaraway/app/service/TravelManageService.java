package com.farfaraway.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farfaraway.app.dao.ITravelManageDAO;
import com.farfaraway.app.dto.TravelManage;

@Service
public class TravelManageService {
	@Autowired
	ITravelManageDAO iTravelManageDAO;

	public List<TravelManage> listTravelManage() {
		return iTravelManageDAO.findAll();
	}

	public TravelManage saveTravelManage(TravelManage travelManage) {
		return iTravelManageDAO.save(travelManage);
	}

	public TravelManage travelManageXID(Long id) {
		return iTravelManageDAO.findById(id).get();
	}

	public TravelManage updateTravelManage(TravelManage travelManage) {
		return iTravelManageDAO.save(travelManage);
	}

	public void deleteTravelManage(Long id) {
		iTravelManageDAO.deleteById(id);
	}
}
