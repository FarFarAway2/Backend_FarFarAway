package com.farfaraway.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.HotelManage;

public interface IHotelManageDAO extends JpaRepository<HotelManage, Long>{

}
