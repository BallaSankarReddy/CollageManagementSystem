package com.collage.exception;

public class CollageStoringDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4687879116523042682L;
	
	private String httpCode;

	public CollageStoringDataException(String errorMessage) {
		super(errorMessage);
	}
	
	public CollageStoringDataException(String errorMessage,String errorCode) {
		super(errorMessage);
		this.httpCode=errorCode;
	}

}
