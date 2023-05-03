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

public class travel_offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_travel, price;
	
	private String image, description, travel_name, transport, 
	expire_date,travel_type,title;
	
	
	@OneToMany(mappedBy = "travel_offer")
	private List<hotel_manage> hotel_man;
	private List<travel_manage> travel_man;
	private List<hotel_book> hotel_book;
	private List<travel_book> travel_book;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private users id_user;
		
	public travel_offer()
	{
		
	}
	public travel_offer(Long id_travel,Long price,String image, String description,String travel_name,String transport, 
	String expire_date,String travel_type,String title, users id_user)
	{
		this.image=image;
		this.description=description;
		this.travel_name=travel_name;
		this.transport=transport;
		this.expire_date=expire_date;
		this.travel_type=travel_type;
		this.title=title;
		this.id_user=id_user;
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
	public users getId_user() {
		return id_user;
	}
	public void setId_user(users id_user) {
		this.id_user = id_user;
	}
	
	
}
