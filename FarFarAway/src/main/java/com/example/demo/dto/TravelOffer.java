package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "travel_offer")
public class TravelOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_travel;

	private Long price;

	private String image, description, travel_name, transport, expire_date, travel_type, title;

	@OneToMany
	@JoinColumn(name = "id_hotel")
	private List<HotelManage> hotel_man;

	@OneToMany
	@JoinColumn(name = "id_travel")
	private List<TravelManage> travel_man;

	@OneToMany
	@JoinColumn(name = "id_hotel")
	private List<HotelBook> HotelBook;

	@OneToMany
	@JoinColumn(name = "id_travel")
	private List<TravelBook> TravelBook;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users id_user;

	public TravelOffer() {

	}

	public TravelOffer(Long price, String image, String description, String travel_name,
			String transport, String expire_date, String travel_type, String title, Users id_user) {
		this.image = image;
		this.description = description;
		this.travel_name = travel_name;
		this.transport = transport;
		this.expire_date = expire_date;
		this.travel_type = travel_type;
		this.title = title;
		this.id_user = id_user;
	}

	public Long getId_travel() {
		return id_travel;
	}

	public void setId_travel(Long id_travel) {
		this.id_travel = id_travel;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTravel_name() {
		return travel_name;
	}

	public void setTravel_name(String travel_name) {
		this.travel_name = travel_name;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	public String getTravel_type() {
		return travel_type;
	}

	public void setTravel_type(String travel_type) {
		this.travel_type = travel_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "HotelManage")
	public List<HotelManage> getHotel_man() {
		return hotel_man;
	}

	public void setHotel_man(List<HotelManage> hotel_man) {
		this.hotel_man = hotel_man;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TravelManage")
	public List<TravelManage> getTravel_man() {
		return travel_man;
	}

	public void setTravel_man(List<TravelManage> travel_man) {
		this.travel_man = travel_man;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "HotelBook")
	public List<HotelBook> getHotel_book() {
		return HotelBook;
	}

	public void setHotel_book(List<HotelBook> HotelBook) {
		this.HotelBook = HotelBook;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TravelBook")
	public List<TravelBook> getTravel_book() {
		return TravelBook;
	}

	public void setTravel_book(List<TravelBook> TravelBook) {
		this.TravelBook = TravelBook;
	}

	public Users getId_user() {
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}

}
