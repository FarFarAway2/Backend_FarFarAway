package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IHotelBookDAO;
import com.example.demo.dto.HotelBook;

@Service
public class HotelBookService {
	@Autowired
	IHotelBookDAO ihotelBookDAO;

	public List<HotelBook> listHotelBooks() {
		return ihotelBookDAO.findAll();
	}

	public HotelBook saveHotelBook(HotelBook hotelBook) {
		return ihotelBookDAO.save(hotelBook);
	}

	public HotelBook hotelBookXID(Long id) {
		return ihotelBookDAO.findById(id).get();
	}

	public HotelBook updateHotelBook(HotelBook hotelBook) {
		return ihotelBookDAO.save(hotelBook);
	}

	public void deleteHotelBook(Long id) {
		ihotelBookDAO.deleteById(id);
	}
}
