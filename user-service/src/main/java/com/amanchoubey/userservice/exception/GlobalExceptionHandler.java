package com.amanchoubey.userservice.exception;

import com.amanchoubey.userservice.model.APIError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIError> handleRuntimeException(RuntimeException ex, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        APIError apiError = new APIError(LocalDateTime.now(),status.value(),status.name(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
