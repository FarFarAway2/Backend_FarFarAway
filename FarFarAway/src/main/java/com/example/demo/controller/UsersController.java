package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UsersService;
import com.example.demo.dto.Users;

@RestController
@RequestMapping("/api")
public class UsersController {

	@Autowired
	UsersService usersService;

	@GetMapping("/users")
	public List<Users> listarUserss() {
		return usersService.listUsers();
	}

	@PostMapping("/users")
	public Users salvarUsers(@RequestBody Users users) {
		return usersService.saveUsers(users);
	}

	@GetMapping("/users/{id}")
	public Users usersXID(@PathVariable(name = "id") Long id) {
		return usersService.usersXID(id);
	}

	@PutMapping("/users/{id}")
	public Users actualizarUsers(@PathVariable(name = "id") Long id, @RequestBody Users users) {

		Users usersSeleccionada = new Users();
		Users usersActualizada = new Users();

		usersSeleccionada = usersService.usersXID(id);

		usersSeleccionada.setId_user(users.getId_user());
		usersSeleccionada.setAge(users.getAge());
		usersSeleccionada.setUser_password(users.getUser_password());
		usersSeleccionada.setEmail(users.getEmail());
		usersSeleccionada.setUser_name(users.getUser_name());
		usersSeleccionada.setSurname(users.getSurname());
		usersSeleccionada.setPhone_number(users.getPhone_number());
		usersSeleccionada.setFiscal_name(users.getFiscal_name());
		usersSeleccionada.setCompany_cif(users.getCompany_cif());

		usersActualizada = usersService.updateUsers(usersSeleccionada);

		return usersActualizada;
	}

	@DeleteMapping("/users/{id}")
	public void eliminarUsers(@PathVariable(name = "id") Long id) {
		usersService.deleteUsers(id);
	}
}
