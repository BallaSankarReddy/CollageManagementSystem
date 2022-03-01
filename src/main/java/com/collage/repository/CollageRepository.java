package com.collage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collage.entity.CollageEntity;


public interface CollageRepository extends JpaRepository<CollageEntity, Integer>{
	
	public CollageEntity  findByCollageCodeOrCollageName(String collageCode,String collageName);

}
