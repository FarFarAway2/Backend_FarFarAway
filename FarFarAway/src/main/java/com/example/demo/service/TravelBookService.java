package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TravelBookDAO;
import com.example.demo.dto.travel_book;

@Service
public class TravelBookService {
	@Autowired
	TravelBookDAO travelBookDAO;

	public List<TravelBooks> listarTravelBooks() {
		return travelBookDAO.findAll();
	}

	public TravelBook guardarTravelBook(TravelBook travelBook) {
		return travelBookDAO.save(travelBook);
	}

	public TravelBook travelBookXID(Long id) {
		return travelBookDAO.findById(id).get();
	}

	public TravelBook actualizarTravelBook(TravelBook travelBook) {
		return travelBookDAO.save(travelBook);
	}

	public void eliminarTravelBook(int id) {
		travelBookDAO.deleteById(id);
	}
}

