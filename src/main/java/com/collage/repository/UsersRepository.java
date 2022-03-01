package com.collage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collage.entity.CollageEntity;
import com.collage.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Integer>{
	

}
