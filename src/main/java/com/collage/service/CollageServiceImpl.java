package com.collage.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collage.entity.CollageEntity;
import com.collage.exception.CollageDataNotFoundException;
import com.collage.exception.CollageStoringDataException;
import com.collage.repository.BranchEnitityRespository;
import com.collage.repository.CollageRepository;
import com.collage.util.JsonObjectConverter;

@Service
public class CollageServiceImpl implements CollageService {
	
	private Logger logger=LoggerFactory.getLogger(CollageServiceImpl.class);
	
	@Autowired
	private CollageRepository collageRepository;
	
	@Autowired
	private BranchEnitityRespository branchEnitityRespository;

	@Override
	public CollageEntity saveOrUpdateCollageEntity(CollageEntity collageEntity) {

		logger.info("Start CollageServiceImpl.saveOrUpdateCollageEntity():{}",collageEntity);
		
		try {
			  collageEntity.setClgId( collageRepository.save(collageEntity).getClgId());
			  
			  if(Optional.ofNullable(collageEntity.getBranchEnitity()).isPresent()) {
				  branchEnitityRespository.save(collageEntity.getBranchEnitity()) ;
			  }
			  
			  logger.info("End CollageServiceImpl.saveOrUpdateCollageEntity():{}",JsonObjectConverter.objectToJsonString(collageEntity));
			  return collageEntity;
		}catch (CollageStoringDataException e) {
			logger.info("Exception occurred CollageServiceImpl.saveOrUpdateCollageEntity():{}",e);
			throw e;
		}
		
	}

	@Override
	public CollageEntity findCollageEntityById(Integer id) {

		logger.info("Start CollageServiceImpl.findCollageEntityById():{}",id);
		
		Optional<CollageEntity> collageEntity = collageRepository.findById(id);
		
		if(!collageEntity.isPresent()) {
			throw new CollageDataNotFoundException("CollageEntity Data Not Found Given Id::"+id,"code::"+"404") ;
		}else {
			logger.info("End CollageServiceImpl.findCollageEntityById():{}",collageEntity.get());
			return collageEntity.get();
		}
		
	}

	@Override
	public CollageEntity findCollageEntityByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollageEntity> getCollageEntitys(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollageEntity findByCollageCodeOrCollageName(String collageCode, String collageName) {
		// TODO Auto-generated method stub
		return null;
	}

}
