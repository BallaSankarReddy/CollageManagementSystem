package com.collage.service;

import java.util.List;

import com.collage.entity.CollageEntity;

public interface CollageService {
	
	//public CollageEntity saveCollageEntity(CollageEntity collageEntity);
	public CollageEntity saveOrUpdateCollageEntity(CollageEntity collageEntity);
	public CollageEntity findCollageEntityById(Integer id);
	public CollageEntity findCollageEntityByCode(String code);
	public List<CollageEntity> getCollageEntitys(Integer offset, Integer limit);
	public CollageEntity  findByCollageCodeOrCollageName(String collageCode,String collageName);
	

}
