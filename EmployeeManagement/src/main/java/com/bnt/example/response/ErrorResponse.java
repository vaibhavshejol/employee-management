package com.bnt.example.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    String message;
    HttpStatus status;
}
