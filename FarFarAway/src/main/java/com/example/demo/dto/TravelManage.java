package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TravelManage")
public class TravelManage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users id_user;

	@ManyToOne
	@JoinColumn(name = "id_travel")
	private TravelOffer id_travel;

	public TravelManage() {
		
	}
	public TravelManage(Users id_user, TravelOffer id_travel)
	{
		this.id_travel=id_travel;
		this.id_user=id_user;
	}

	public Users getId_user() {
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}

	public TravelOffer getId_travel() {
		return id_travel;
	}

	public void setId_travel(TravelOffer id_travel) {
		this.id_travel = id_travel;
	}

}
