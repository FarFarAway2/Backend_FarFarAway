package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITravelBookDAO;
import com.example.demo.dto.TravelBook;
import com.example.demo.dto.Users;

@Service
public class TravelBookService {
	@Autowired
	ITravelBookDAO travelBookDAO;

	public List<TravelBook> listarTravelBooks() {
		return travelBookDAO.findAll();
	}

	public TravelBook guardarTravelBook(TravelBook travelBook) {
		return travelBookDAO.save(travelBook);
	}

	public TravelBook travelBookXID(Users id) {
		return travelBookDAO.findById(id).get();
	}

	public TravelBook actualizarTravelBook(TravelBook travelBook) {
		return travelBookDAO.save(travelBook);
	}

	public void eliminarTravelBook(Users id) {
		travelBookDAO.deleteById(id);
	}
}

