package com.sk.testmvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCustomerNotFound(CustomerNotFoundException exception){
        System.out.println("Exception " + exception.getMessage());
        ApiErrorResponse errorResponse = new ApiErrorResponse("CUSTOMERS_NOT_FOUND_001", exception.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApiErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
