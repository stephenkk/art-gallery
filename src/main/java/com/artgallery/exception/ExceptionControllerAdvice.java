package com.artgallery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(ArtGalleryException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ArtGalleryException ex){
		ErrorResponse error = new ErrorResponse();
		error.setMessage(ex.getMessage());
		
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	


}
