package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.TravelManage;

public interface ITravelManageDAO extends JpaRepository<TravelManage, Long>{

}
