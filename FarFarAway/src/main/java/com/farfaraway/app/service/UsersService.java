package com.farfaraway.app.service;

import java.util.List;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.farfaraway.app.dao.UserRepository;
import com.farfaraway.app.dto.Users;
import com.farfaraway.app.exception.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class UsersService implements IUserService{
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;	

	public List<Users> listUsers() {
		return userRepository.findAll();
	}

	public Users saveUsers(Users user) {
		user.setUser_password(passwordEncoder.encode(user.getUser_password()));
		return userRepository.save(user);
	}

	public Users usersXID(Long id) {
		return userRepository.findById(id).get();
	}

	public Users updateUsers(Users user) {
		user.setUser_password(passwordEncoder.encode(user.getUser_password()));
		return userRepository.save(user);
	}

	public void deleteUsers(Long id) {
		userRepository.deleteById(id);
	}

	public Users findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Transactional
	public void deleteByEmail(String email) {
		userRepository.deleteByEmail(email);
	}
}