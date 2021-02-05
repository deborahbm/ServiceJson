package com.dbm.hibernate.excepciones;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


@ControllerAdvice
public class ControladorGlobalExcepciones {

	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		DetallesError detallesError = new DetallesError(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(detallesError, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		DetallesError detallesError = new DetallesError(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detallesError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

	
}
