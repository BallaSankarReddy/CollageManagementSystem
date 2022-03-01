package com.collage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collage.entity.Users;
import com.collage.service.UsersService;

@CrossOrigin("*")
@RestController
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	
	@PostMapping("/users")
	public Users saveUsers(@RequestBody Users users) {
		return service.saveUsers(users);
	}
	@GetMapping("/users")
	public List<Users> getUsers(){
		return service.getUsers();
	}
	@DeleteMapping("/users/{id}" )
	public Users deleteUser(@PathVariable("id") Integer id) {
		Users user = service.getUser(id);
		service.deletUser(id);
		return user;
	}

}
