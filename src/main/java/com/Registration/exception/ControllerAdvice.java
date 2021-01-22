package com.Registration.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotUnique.class)
	public ResponseEntity<Object> handleNotUniqueException(DataNotUnique ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("Error", "Data should be unique");
		return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);
	}
}
