package com.workintech.s19d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class ApiGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleApiException(ApiException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), exception.getHttpStatus().value(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, exception.getHttpStatus());

    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleApiException(Exception exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}