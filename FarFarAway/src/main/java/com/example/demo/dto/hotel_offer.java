package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class hotel_offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_hotel, price, rating;
	
	private String image,expire_date,longitude,latitude,location,hotel_name
	,title;
	
	
	@OneToMany(mappedBy = "hotel_offer")
	private List<hotel_manage> hotel_man;
	private List<travel_manage> travel_man;
	private List<hotel_book> hotel_book;
	private List<travel_book> travel_book;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private users id_user;
	
	public hotel_offer()
	{
		
	}
	public hotel_offer(Long id_travel,Long price,String image, String longitude,String latitude,String hotel_name, 
	String expire_date,String location,String title, users id_user)
	{
		this.image=image;
		this.longitude=longitude;
		this.latitude=latitude;
		this.hotel_name=hotel_name;
		this.expire_date=expire_date;
		this.location=location;
		this.title=title;
		this.id_user=id_user;
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
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel_manage")
	public List<hotel_manage> getHotel_man() {
		return hotel_man;
	}
	public void setHotel_man(List<hotel_manage> hotel_man) {
		this.hotel_man = hotel_man;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "travel_manage")
	public List<travel_manage> getTravel_man() {
		return travel_man;
	}
	public void setTravel_man(List<travel_manage> travel_man) {
		this.travel_man = travel_man;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel_book")
	public List<hotel_book> getHotel_book() {
		return hotel_book;
	}
	public void setHotel_book(List<hotel_book> hotel_book) {
		this.hotel_book = hotel_book;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "travel_book")
	public List<travel_book> getTravel_book() {
		return travel_book;
	}
	public void setTravel_book(List<travel_book> travel_book) {
		this.travel_book = travel_book;
	}
	
}
