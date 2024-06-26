package com.chatop.handler;

import com.chatop.dto.ResponseDTO;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { AuthenticationException.class})
    protected ResponseEntity<ResponseDTO> handleAuthenticationError(AuthenticationException ex, WebRequest request) {
        String errorMsg = "";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(errorMsg));
    }

    @ExceptionHandler(value = { EntityExistsException.class, })
    protected ResponseEntity<ResponseDTO> handleEntityExistError(EntityExistsException ex, WebRequest request) {
        String errorMsg = "";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(errorMsg));
    }

    @ExceptionHandler(value = { EntityNotFoundException.class})
    protected ResponseEntity<ResponseDTO> handleEntityNotFoundError(EntityNotFoundException ex, WebRequest request) {
        String errorMsg = "";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(errorMsg));
    }

    @ExceptionHandler(value = { IOException.class})
    protected ResponseEntity<ResponseDTO> handleIOError(IOException ex, WebRequest request) {
        String errorMsg = "";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(errorMsg));
    }

    @ExceptionHandler(value = { BadCredentialsException.class})
    protected ResponseEntity<ResponseDTO> handleBadCredentialsError(BadCredentialsException ex, WebRequest request) {
        String errorMsg = "error";
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO(errorMsg));
    }
}
