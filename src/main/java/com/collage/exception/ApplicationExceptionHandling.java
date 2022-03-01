package com.collage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandling {
	
	@ExceptionHandler(CollageDataNotFoundException.class)
	public ResponseEntity<?> handlingCollageDataNotFoundException(CollageDataNotFoundException ex) {

		return  ResponseEntity.badRequest().body(ex.errorMessage);
	}
	
	
	@ExceptionHandler(CollageStoringDataException.class)
	public ResponseEntity<?> handlingCollageStoringDataException(CollageStoringDataException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
}
