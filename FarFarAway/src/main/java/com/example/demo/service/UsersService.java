package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsersDAO;
import com.example.demo.dto.Users;

@Service
public class UsersService {
	@Autowired
	IUsersDAO iUsersDAO;

	public List<Users> listUsers() {
		return iUsersDAO.findAll();
	}

	public Users saveUsers(Users Users) {
		return iUsersDAO.save(Users);
	}

	public Users usersXID(Long id) {
		return iUsersDAO.findById(id).get();
	}

	public Users updateUsers(Users Users) {
		return iUsersDAO.save(Users);
	}

	public void deleteUsers(Long id) {
		iUsersDAO.deleteById(id);
	}
}