package com.artgallery.exception;

public class ArtGalleryException extends RuntimeException{
	private String errorMessage;

	public ArtGalleryException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	
	
	
	

}
