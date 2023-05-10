package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "travel_manage")
public class TravelManage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_travel_manage;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users id_user;

	@ManyToOne
	@JoinColumn(name = "id_travel")
	private TravelOffer id_travel;

	public TravelManage() {

	}

	public TravelManage(Users id_user, TravelOffer id_travel) {
		this.id_travel = id_travel;
		this.id_user = id_user;
	}
	
	public Long getId_travel_manage() {
		return id_travel_manage;
	}
	
	public void setId_travel_manage(Long id_travel_manage) {
		this.id_travel_manage = id_travel_manage;
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
