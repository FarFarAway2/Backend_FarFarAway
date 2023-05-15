package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITravelBookDAO;
import com.example.demo.dto.TravelBook;

@Service
public class TravelBookService {
	@Autowired
	ITravelBookDAO iTravelBookDAO;

	public List<TravelBook> listTravelBooks() {
		return iTravelBookDAO.findAll();
	}

	public TravelBook saveTravelBook(TravelBook travelBook) {
		return iTravelBookDAO.save(travelBook);
	}

	public TravelBook travelBookXID(Long id) {
		return iTravelBookDAO.findById(id).get();
	}

	public TravelBook updateTravelBook(TravelBook travelBook) {
		return iTravelBookDAO.save(travelBook);
	}

	public void deleteTravelBook(Long id) {
		iTravelBookDAO.deleteById(id);
	}
}
