package com.aturiasrest.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errores = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String nombreCampo = ((FieldError) error).getField();
			String mensaje = error.getDefaultMessage();

			errores.put(nombreCampo, mensaje);
		});

		return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(ErrorNotFoundException.class)
	public final ResponseEntity<Map<String, List<String>>> handleGeneralExceptions(Exception ex) {
	    List<String> errors = Collections.singletonList(ex.getMessage());
	    return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(ErrorNotFoundException.class)
//	public final ResponseEntity<Map<String, List<String>>> handleGeneralExceptionsConflic(Exception ex) {
//	    List<String> errors = Collections.singletonList(ex.getMessage());
//	    return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.CONFLICT);
//	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Map<String, List<String>>> handleRuntimeExceptions(RuntimeException ex) {
	    List<String> errors = Collections.singletonList(ex.getMessage());
	    return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}