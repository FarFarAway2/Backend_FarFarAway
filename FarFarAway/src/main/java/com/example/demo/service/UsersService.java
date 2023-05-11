package com.example.demo.service;

import static java.util.Collections.emptyList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsersDAO;
import com.example.demo.dto.Users;

@Service
public class UsersService implements UserDetailsService{
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user = iUsersDAO.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new User(user.getEmail(), user.getUser_password(), emptyList());
	}
}