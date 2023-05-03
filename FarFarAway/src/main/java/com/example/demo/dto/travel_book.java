package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "travel_book")
public class travel_book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@ManyToOne
	@JoinColumn(name = "id_user")
	private users id_user;

	@ManyToOne
	@JoinColumn(name = "id_travel")
	private travel_offer id_travel;

	public travel_book() {
		
	}
	public travel_book(users id_user, travel_offer id_travel)
	{
		this.id_travel=id_travel;
		this.id_user=id_user;
	}

	public users getId_user() {
		return id_user;
	}

	public void setId_user(users id_user) {
		this.id_user = id_user;
	}

	public travel_offer getId_travel() {
		return id_travel;
	}

	public void setId_travel(travel_offer id_travel) {
		this.id_travel = id_travel;
	}

}
