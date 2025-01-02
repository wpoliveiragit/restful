package br.com.pegasus.restful.app.controller;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.pegasus.restful.infra.exception.AdviceBadRequestException;
import br.com.pegasus.restful.infra.exception.AdviceConflictException;
import br.com.pegasus.restful.infra.exception.AdviceNotFoundException;
import br.com.pegasus.restful.infra.method.AppMethod;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class AdviceController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> globalException(Exception ex, WebRequest request) {
		return AppMethod.createExceptionResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> conflictException(MethodArgumentNotValidException ex,
			WebRequest request) {

		String msg = Stream.of(ex.getDetailMessageArguments())//
				.filter(obj -> obj instanceof String)//
				.map(String.class::cast)//
				.collect(Collectors.joining());
		return AppMethod.createExceptionResponse(msg, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, Object>> conflictException(ConstraintViolationException ex, WebRequest request) {

		String msg = ex.getConstraintViolations().stream()//
				.map(violation -> violation.getMessage())//
				.collect(Collectors.joining());
		return AppMethod.createExceptionResponse(msg, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(AdviceConflictException.class)
	public ResponseEntity<Map<String, Object>> conflictException(AdviceConflictException ex, WebRequest request) {
		return AppMethod.createExceptionResponse(ex.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(AdviceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleNoSuchElementException(AdviceNotFoundException ex,
			WebRequest request) {
		return AppMethod.createExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdviceBadRequestException.class)
	public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(AdviceBadRequestException ex,
			WebRequest request) {
		return AppMethod.createExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
