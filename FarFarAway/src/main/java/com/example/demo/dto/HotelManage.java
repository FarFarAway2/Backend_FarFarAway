package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_manage")
public class HotelManage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_hotel_manage;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users id_user;

	@ManyToOne
	@JoinColumn(name = "id_hotel")
	private HotelOffer id_hotel;

	public HotelManage() {

	}

	public HotelManage(Users id_user, HotelOffer id_hotel) {
		this.id_hotel = id_hotel;
		this.id_user = id_user;
	}
	
	public Long getId_hotel_manage() {
		return id_hotel_manage;
	}
	
	public void setId_hotel_manage(Long id_hotel_manage) {
		this.id_hotel_manage = id_hotel_manage;
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
