package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.HotelManage;
import com.example.demo.dto.Users;

public interface IHotelManageDAO extends JpaRepository<HotelManage, Long>{

}
