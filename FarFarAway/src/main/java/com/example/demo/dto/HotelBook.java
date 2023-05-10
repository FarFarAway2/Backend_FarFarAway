package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_book")
public class HotelBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_hotel_book;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users id_user;

	@ManyToOne
	@JoinColumn(name = "id_hotel")
	private HotelOffer id_hotel;

	public HotelBook() {

	}

	public HotelBook(Users id_user, HotelOffer id_hotel) {
		this.id_hotel = id_hotel;
		this.id_user = id_user;
	}

	public Long getId_hotel_book() {
		return id_hotel_book;
	}
	
	public void setId_hotel_book(Long id_hotel_book) {
		this.id_hotel_book = id_hotel_book;
	}
	
	public Users getId_user() {
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}

	public HotelOffer getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(HotelOffer id_hotel) {
		this.id_hotel = id_hotel;
	}

}
