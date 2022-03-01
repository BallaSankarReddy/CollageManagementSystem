package com.collage.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CollageDataNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2009225102146589487L;
	
	private String httpCode;
	String errorMessage;

	public CollageDataNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	
	
	public CollageDataNotFoundException(String errorMessage,String errorCode) {
		super(errorMessage);
		this.errorMessage=errorMessage;
		this.httpCode=errorCode;
	}



	public String getHttpCode() {
		return httpCode;
	}



	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}
	
	
}
