package com.farfaraway.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farfaraway.app.dto.TravelManage;

public interface ITravelManageDAO extends JpaRepository<TravelManage, Long>{

}
