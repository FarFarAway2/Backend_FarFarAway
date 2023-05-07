package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IHotelBookDAO;
import com.example.demo.dto.HotelBook;
import com.example.demo.dto.Users;

@Service
public class HotelBookService {
	@Autowired
	IHotelBookDAO hotelBookDAO;

	public List<HotelBook> listHotelBooks() {
		return hotelBookDAO.findAll();
	}

	public HotelBook saveHotelBook(HotelBook hotelBook) {
		return hotelBookDAO.save(hotelBook);
	}

	public HotelBook hotelBookXID(Long id) {
		return hotelBookDAO.findById(id).get();
	}

	public HotelBook updateHotelBook(HotelBook hotelBook) {
		return hotelBookDAO.save(hotelBook);
	}

	public void deleteHotelBook(Long id) {
		hotelBookDAO.deleteById(id);
	}
}
