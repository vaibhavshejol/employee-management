package com.bnt.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bnt.example.response.ErrorResponse;

@ControllerAdvice
public class GlobleExceptionHandler extends Exception {
    
    @ExceptionHandler(UnknownException.class)
    public ResponseEntity<ErrorResponse> unknownException(UnknownException unknownException){
        ErrorResponse response = new ErrorResponse(unknownException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> allException(Exception exception){
        ErrorResponse response = new ErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
