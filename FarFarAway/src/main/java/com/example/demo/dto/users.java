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
@Table(name = "users")
public class users {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user, age;

	private String user_password, user_name, email, surname, 
	phone_number, fiscal_name, company_cif ;


	@OneToMany(mappedBy = "users")
	private List<user_role> user_rol;
	private List<hotel_offer> hotel_off;
	private List<travel_offer> travel_off;
	private List<hotel_manage> hotel_man;
	private List<travel_manage> travel_man;
	private List<hotel_book> hotel_book;
	private List<travel_book> travel_book;
	

	// Constructors
	public users() {
	}

	public users(Long id_user,String user_password,String user_name,String email,String surname,
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user_role")
	public List<user_role> getUser_rol() {
		return user_rol;
	}

	
	public void setUser_rol(List<user_role> user_rol) {
		this.user_rol = user_rol;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel_offer")
	public List<hotel_offer> getHotel_off() {
		return hotel_off;
	}
	
	public void setHotel_off(List<hotel_offer> hotel_off) {
		this.hotel_off = hotel_off;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "travel_offer")
	public List<travel_offer> getTravel_off() {
		return travel_off;
	}

	public void setTravel_off(List<travel_offer> travel_off) {
		this.travel_off = travel_off;
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

