/**
 * Utility packages to handle Exceptions and Aspects
 */
package com.rewards.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rewards.exception.CustomerRewardPointException;

/**
 * ExceptionControllerAdvice class to handle various exceptions
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	Environment environment;

	/**
	 * Exception handled when any internal error found
	 * @param exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Exception handled when Customer data not found in DB
	 * @param exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(CustomerRewardPointException.class)
	public ResponseEntity<ErrorInfo> infyBankexceptionHandler(CustomerRewardPointException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(exception.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Exception handled for invalid format data 
	 * @param exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		    errorInfo.setTimestamp(LocalDateTime.now());
			
			String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(", "));
			errorInfo.setErrorMessage(errorMsg);
		
			return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	 
	/**
	 * Exception handled for invalid format for path variable
	 * @param exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInfo> pathExceptionHandler(ConstraintViolationException exception) {

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());

		String errorMsg = exception.getConstraintViolations().stream().map(x -> x.getMessage())
				.collect(Collectors.joining(", "));
		errorInfo.setErrorMessage(errorMsg);
		errorInfo.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

}
