package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersDAO;
import com.example.demo.dto.users;

@Service
public class UsersService {
	@Autowired
	UsersDAO usersDAO;

	public List<Users> listarUsers() {
		return usersDAO.findAll();
	}

	public Users guardarUsers(Users users) {
		return usersDAO.save(users);
	}

	public Users usersXID(Long id) {
		return usersDAO.findById(id).get();
	}

	public Users actualizarUsers(Users users) {
		return usersDAO.save(users);
	}

	public void eliminarUsers(int id) {
		usersDAO.deleteById(id);
	}
}