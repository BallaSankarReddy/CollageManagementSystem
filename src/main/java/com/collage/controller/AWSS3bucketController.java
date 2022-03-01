package com.collage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.collage.service.S3StorageService;

@RestController
@RequestMapping("/files")
public class AWSS3bucketController {

	@Autowired
	private S3StorageService s3StorageService;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
return	new ResponseEntity<>(s3StorageService.uploadFile(file),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
		
	  byte[] downloadFile = s3StorageService.downloadFile(fileName);
	  
	  ByteArrayResource resource = new ByteArrayResource(downloadFile);
	
	   return ResponseEntity.ok().contentType(contentType(fileName)).contentLength(downloadFile.length)
	   .header("content-type", "application/octet-stream")
	   .header("content-disposition", "attachment; filename=\""+fileName+"\"").body(resource);
	
	}
	
	@DeleteMapping("/delete/{fileName}")
	public ResponseEntity<String> deleteFile(@PathVariable  String fileName) {
		
		return new ResponseEntity<>(s3StorageService.deleteFile(fileName),HttpStatus.OK);
		
	}
	
	
	 private MediaType contentType(String filename) {
	        String[] fileArrSplit = filename.split("\\.");
	        String fileExtension = fileArrSplit[fileArrSplit.length - 1];
	        switch (fileExtension) {
	            case "txt":
	                return MediaType.TEXT_PLAIN;
	            case "png":
	                return MediaType.IMAGE_PNG;
	            case "jpg":
	                return MediaType.IMAGE_JPEG;
	            default:
	                return MediaType.APPLICATION_OCTET_STREAM;
	        }
	    }
	
	
}
