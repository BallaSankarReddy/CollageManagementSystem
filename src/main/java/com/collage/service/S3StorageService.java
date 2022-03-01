package com.collage.service;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Service
public class S3StorageService {

	private Logger logger=LoggerFactory.getLogger(S3StorageService.class);
	@Value("${app.awsServices.bucketName}")
	private String bucketName;
	
	@Autowired
	private com.amazonaws.services.s3.AmazonS3Client amazonS3Client;
	
	public String uploadFile(MultipartFile file) {
		
		File fileObject = this.converteMultipartFileToFile(file);
		
		
		Date date = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMdd");
		String fileDateFormat = dateFormat.format(date);
		//220222_balla.txt
		String fileName=fileDateFormat+"_"+file.getOriginalFilename();
		//amazonS3Client
		amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName,fileObject));
		fileObject.delete();
		return "File uploaded:"+fileName;
	}
	
	private File converteMultipartFileToFile(MultipartFile file) {
		
		File convertedFile = new File(file.getOriginalFilename());
		
		try (FileOutputStream fos= new FileOutputStream(convertedFile)){
			fos.write(file.getBytes());
			
		}catch (Exception e) {
			
			logger.error("Error converted MultipartFile To File:{} ",e);
		}
		return convertedFile;
	}
	
	
	public byte[] downloadFile(String fileName) {
		
		S3Object s3Object = amazonS3Client.getObject(bucketName,fileName);
		
		S3ObjectInputStream objectContent = s3Object.getObjectContent();
		
		try {
			byte[] byteArray = IOUtils.toByteArray(objectContent);
			
			return byteArray;
		}catch (Exception e) {
			logger.error("Error downloadFile:{} ",e);
		}
		return null;
	}
	
	
	public String deleteFile(String fileName) {
		
		amazonS3Client.deleteObject(bucketName,fileName);
		
		return fileName+" removed...";
		
	}
}
