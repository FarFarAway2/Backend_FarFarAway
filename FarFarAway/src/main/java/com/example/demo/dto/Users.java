package com.example.demo.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user, age;

	private String user_password, user_name, email, surname, 
	phone_number, fiscal_name, company_cif ;


	@OneToMany(mappedBy = "Users")
	private List<UserRole> user_rol;
	private List<HotelOffer> hotel_off;
	private List<TravelOffer> travel_off;
	private List<HotelManage> hotel_man;
	private List<TravelManage> travel_man;
	private List<HotelBook> HotelBook;
	private List<TravelBook> TravelBook;
	

	// Constructors
	public Users() {
	}

	public Users(Long id_user,String user_password,String user_name,String email,String surname,
			String phone_number,String fisical_name,String company_cif,Long age) {
		this.id_user=id_user;
		this.age= age;
		this.user_password=user_password;
		this.user_name=user_name;
		this.email=email;
		this.surname=surname;
		this.phone_number=phone_number;
		//for a company 
		this.fiscal_name=fisical_name;
		this.company_cif=company_cif;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFiscal_name() {
		return fiscal_name;
	}

	public void setFiscal_name(String fiscal_name) {
		this.fiscal_name = fiscal_name;
	}

	public String getCompany_cif() {
		return company_cif;
	}

	public void setCompany_cif(String company_cif) {
		this.company_cif = company_cif;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "UserRole")
	public List<UserRole> getUser_rol() {
		return user_rol;
	}

	
	public void setUser_rol(List<UserRole> user_rol) {
		this.user_rol = user_rol;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "HotelOffer")
	public List<HotelOffer> getHotel_off() {
		return hotel_off;
	}
	
	public void setHotel_off(List<HotelOffer> hotel_off) {
		this.hotel_off = hotel_off;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TravelOffer")
	public List<TravelOffer> getTravel_off() {
		return travel_off;
	}

	public void setTravel_off(List<TravelOffer> travel_off) {
		this.travel_off = travel_off;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone_number() {
		return phone_number;
	}

}

