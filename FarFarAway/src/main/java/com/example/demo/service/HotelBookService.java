package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HotelBookDAO;
import com.example.demo.dto.hotel_book;

@Service
public class HotelBookService {
	@Autowired
	HotelBookDAO hotelBookDAO;

	public List<HotelBooks> listarHotelBooks() {
		return hotelBookDAO.findAll();
	}

	public HotelBook guardarHotelBook(HotelBook hotelBook) {
		return hotelBookDAO.save(hotelBook);
	}

	public HotelBook hotelBookXID(Long id) {
		return hotelBookDAO.findById(id).get();
	}

	public HotelBook actualizarHotelBook(HotelBook hotelBook) {
		return hotelBookDAO.save(hotelBook);
	}

	public void eliminarHotelBook(int id) {
		hotelBookDAO.deleteById(id);
	}
}
