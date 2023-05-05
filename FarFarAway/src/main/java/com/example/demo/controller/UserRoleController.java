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

import com.example.demo.dto.Users;
import com.example.demo.dto.UserRole;
import com.example.demo.service.UserRoleService;

@RestController
public class UserRoleController {

	@Autowired
	UserRoleService userRoleService;

	@GetMapping("/userrole")
	public List<UserRole> listUserRoles() {
		return userRoleService.listUserRoles();
	}

	@PostMapping("/userrole")
	public UserRole saveUserRole(@RequestBody UserRole userRole) {
		return userRoleService.saveUserRole(userRole);
	}

	@GetMapping("/userrole/{id}")
	public UserRole userRoleXID(@PathVariable(name = "id") Users id) {
		return userRoleService.userRoleXID(id);
	}

	@PutMapping("/userrole/{id}")
	public UserRole actualizarUserRole(@PathVariable(name = "id") Users id, @RequestBody UserRole userRole) {

		UserRole userRoleSeleccionado = new UserRole();
		UserRole userRoleActualizado = new UserRole();

		userRoleSeleccionado = userRoleService.userRoleXID(id);
		userRoleSeleccionado.setId_user(userRole.getId_user());
		userRoleSeleccionado.setId_role(userRole.getId_role());

		userRoleActualizado = userRoleService.updateUserRole(userRoleSeleccionado);

		return userRoleActualizado;
	}

	@DeleteMapping("/userrole/{id}")
	public void eliminarUserRole(@PathVariable(name = "id") Users id) {
		userRoleService.deleteUserRole(id);
	}
}
