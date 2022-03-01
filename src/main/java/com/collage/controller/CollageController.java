package com.collage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collage.entity.CollageEntity;
import com.collage.service.CollageService;

@RestController
public class CollageController {

	@Autowired
	private CollageService collageService;
	
	@PostMapping("/collage")
	public CollageEntity saveCollageEntity(@RequestBody CollageEntity collageEntity) {
		return collageService.saveOrUpdateCollageEntity(collageEntity);
		
	}
	
	@GetMapping("/collage")
	public CollageEntity findCollageEntityById(@RequestParam("id") Integer id) {
		
		return collageService.findCollageEntityById(id);
	}
}
