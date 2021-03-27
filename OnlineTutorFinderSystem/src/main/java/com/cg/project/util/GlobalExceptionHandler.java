package com.cg.project.util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.project.exceptions.GlobalException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(GlobalException.class)
	public final ResponseEntity<ExceptionResponse> handleGlobalException(GlobalException ex, WebRequest req) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),

				req.getDescription(false), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

	}

}