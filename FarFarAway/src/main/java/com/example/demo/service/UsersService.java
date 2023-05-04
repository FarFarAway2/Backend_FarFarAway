package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsersDAO;
import com.example.demo.dto.Users;

@Service
public class UsersService {
	@Autowired
	IUsersDAO UsersDAO;

	public List<Users> listarUsers() {
		return UsersDAO.findAll();
	}

	public Users guardarUsers(Users Users) {
		return UsersDAO.save(Users);
	}

	public Users UsersXID(Long id) {
		return UsersDAO.findById(id).get();
	}

	public Users actualizarUsers(Users Users) {
		return UsersDAO.save(Users);
	}

	public void eliminarUsers(Long id) {
		UsersDAO.deleteById(id);
	}
}