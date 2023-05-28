package com.farfaraway.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "travel_offer")
public class TravelOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_travel;

	private Long price;

	private String image, travel_description, travel_name, transport;
	@Column(name = "expire_date")
	private LocalDate expireDate;
	@Column(name = "travel_type")
	private String travelType;
	private String title;

	private boolean travel_active;

	private String destination;

	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;

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

	public TravelOffer(Long price, String image, String travel_description, String travel_name, String transport,
			LocalDate expireDate, String travelType, String title, boolean travel_active, Users id_user,
			String destination, LocalDate startDate, LocalDate endDate) {
		this.image = image;
		this.travel_description = travel_description;
		this.travel_name = travel_name;
		this.transport = transport;
		this.expireDate = expireDate;
		this.travelType = travelType;
		this.title = title;
		this.travel_active = travel_active;
		this.id_user = id_user;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public String getTravel_Description() {
		return travel_description;
	}

	public void setTravel_Description(String travel_description) {
		this.travel_description = travel_description;
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

	public LocalDate getExpire_date() {
		return expireDate;
	}

	public void setExpire_date(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public String getTravel_type() {
		return travelType;
	}

	public void setTravel_type(String travelType) {
		this.travelType = travelType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getStart_date() {
		return startDate;
	}

	public void setStart_date(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEnd_date() {
		return endDate;
	}

	public void setEnd_date(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Users getId_user() {
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}

	public boolean getTravel_active() {
		return travel_active;
	}

	public void setTravel_active(boolean travel_active) {
		this.travel_active = travel_active;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "HotelManage")
	public List<HotelManage> getHotel_man() {
		return hotel_man;
	}

	public void setHotel_man(List<HotelManage> hotel_man) {
		this.hotel_man = hotel_man;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "TravelManage")
	public List<TravelManage> getTravel_man() {
		return travel_man;
	}

	public void setTravel_man(List<TravelManage> travel_man) {
		this.travel_man = travel_man;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "HotelBook")
	public List<HotelBook> getHotel_book() {
		return HotelBook;
	}

	public void setHotel_book(List<HotelBook> HotelBook) {
		this.HotelBook = HotelBook;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "TravelBook")
	public List<TravelBook> getTravel_book() {
		return TravelBook;
	}

	public void setTravel_book(List<TravelBook> TravelBook) {
		this.TravelBook = TravelBook;
	}
}
