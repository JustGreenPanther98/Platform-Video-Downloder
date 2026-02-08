package com.video.exceptions;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class Exceptions {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherException(Exception exception, WebRequest request) {

		ExceptionMessage errorMessage = new ExceptionMessage(new Date(), exception.getMessage());
		
		var header = new HttpHeaders();
		header.set("Error", errorMessage.toString());

		return new ResponseEntity<>(errorMessage, header, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
