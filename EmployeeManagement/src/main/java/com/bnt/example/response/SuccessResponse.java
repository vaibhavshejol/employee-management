package com.bnt.example.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuccessResponse {
    String message;
    Object object;
    HttpStatus status;
}
