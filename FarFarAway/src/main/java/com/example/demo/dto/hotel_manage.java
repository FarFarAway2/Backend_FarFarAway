package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_manage")
public class hotel_manage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@ManyToOne
	@JoinColumn(name = "id_user")
	private users id_user;

	@ManyToOne
	@JoinColumn(name = "id_hotel")
	private hotel_offer id_hotel;

	public hotel_manage() {
		
	}
	public hotel_manage(users id_user, hotel_offer id_hotel)
	{
		this.id_hotel=id_hotel;
		this.id_user=id_user;
	}

	public users getId_user() {
		return id_user;
	}

	public void setId_user(users id_user) {
		this.id_user = id_user;
	}

	public hotel_offer getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(hotel_offer id_hotel) {
		this.id_hotel = id_hotel;
	}

}
