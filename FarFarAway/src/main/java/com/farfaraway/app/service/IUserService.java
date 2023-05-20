package com.farfaraway.app.service;

import java.util.List;

import com.farfaraway.app.dto.Users;

public interface IUserService {

	List<Users> listUsers();

	Users saveUsers(Users Users);

	Users usersXID(Long id);

	Users updateUsers(Users Users);

	void deleteUsers(Long id);

	Users findByEmail(String email);

	void deleteByEmail(String email);
}
