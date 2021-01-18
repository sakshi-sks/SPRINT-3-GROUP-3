package com.tnp.student.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler  {

	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException exception, WebRequest request) {
	ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateStudentException.class)
	public final ResponseEntity<Object> handleDuplicateException(DuplicateStudentException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationExceptionHandling(MethodArgumentNotValidException exception)
	{
		ErrorDetails errorDetails=
				               new ErrorDetails(new Date(), "Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {InputException.class})
	public ResponseEntity<Object> handleAnyRequest(InputException ex,WebRequest request)
	{
		return new ResponseEntity<>(ex.getLocalizedMessage(),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<Object> handleAnyRequest(ResourceNotFoundException ex,WebRequest request)
	{
		return new ResponseEntity<>(ex.getLocalizedMessage(),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
