package com.farfaraway.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "hotel_offer")
public class HotelOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_hotel;

	private Long price, rating;

	private String image, expire_date, longitude, latitude, location, hotel_name, title;

	@OneToMany
	@JoinColumn(name = "id_hotel")
	private List<HotelManage> HotelManage;

	@OneToMany
	@JoinColumn(name = "id_travel")
	private List<TravelManage> TravelManage;

	@OneToMany
	@JoinColumn(name = "id_hotel")
	private List<HotelBook> HotelBook;

	@OneToMany
	@JoinColumn(name = "id_travel")
	private List<TravelBook> TravelBook;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users id_user;

	public HotelOffer() {

	}

	public HotelOffer(String image, String longitude, String latitude, String hotel_name,
			String expire_date, String location, String title, Users id_user) {
		this.image = image;
		this.longitude = longitude;
		this.latitude = latitude;
		this.hotel_name = hotel_name;
		this.expire_date = expire_date;
		this.location = location;
		this.title = title;
		this.id_user = id_user;
	}

	public Long getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(Long id_hotel) {
		this.id_hotel = id_hotel;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Users getId_user() {
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "HotelManage")
	public List<HotelManage> getHotel_man() {
		return HotelManage;
	}

	public void setHotel_man(List<HotelManage> HotelManage) {
		this.HotelManage = HotelManage;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TravelManage")
	public List<TravelManage> getTravel_man() {
		return TravelManage;
	}

	public void setTravel_man(List<TravelManage> TravelManage) {
		this.TravelManage = TravelManage;
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

}
