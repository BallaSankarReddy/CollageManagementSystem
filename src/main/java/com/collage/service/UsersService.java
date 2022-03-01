package com.collage.service;

import java.util.List;

import com.collage.entity.Users;

public interface UsersService {
	
	public Users saveUsers(Users users);
	public List<Users> getUsers();
	
	public Users getUser(Integer id);

	
	public Integer deletUser(Integer id);
}
