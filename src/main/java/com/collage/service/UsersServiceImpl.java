package com.collage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.collage.entity.Users;
import com.collage.repository.UsersRepository;
import com.collage.util.JsonObjectConverter;

@Service
public class UsersServiceImpl implements UsersService {
	
	private Logger logger=LoggerFactory.getLogger(UsersServiceImpl.class);
	
	@Autowired
	private UsersRepository repository;

	@Override
	public Users saveUsers(Users users) {

		logger.info("Started UsersServiceImpl.saveUsers():{}");
		
		Integer userId = Optional.ofNullable(repository.save(users).getId()).filter(user -> null!=user).orElseGet(null);
		//repository.save(users);
		users.setId(userId);
		logger.info("End UsersServiceImpl.saveUsers():{}",JsonObjectConverter.objectToJsonString(users));
		
		return users;
	}

	@Override
	public List<Users> getUsers() {

		logger.info("Started UsersServiceImpl.getUsers()");
		
		List<Users> users = repository.findAll();
		
		
		if(CollectionUtils.isEmpty(users)) {
			
			users=listOfUsers();
		}
		logger.info("End UsersServiceImpl.getUsers():{}",JsonObjectConverter.objectToJsonString(users));
		return users;
	}
	
	
	
	private List<Users> listOfUsers(){
		
		List<Users> users = new ArrayList<>();
		Users user1 = new Users();
		user1.setId(1);
		user1.setName("user1");
		user1.setType( "admin");
		user1.setPassword("pass");
		
		Users user2 = new Users();
		user2.setId(2);
		user2.setName("user1");
		user2.setType( "admin");
		user2.setPassword("pass");
		
		users.add(user1);users.add(user2);
		return users;
		
		
	}

	@Override
	public Users getUser(Integer id) {

		
		return repository.findById(id).get();
	}

	@Override
	public Integer deletUser(Integer id) {

		repository.deleteById(id);
		return id;
	}

}
