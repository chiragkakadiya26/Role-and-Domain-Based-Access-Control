package com.accesscontrol.exeption;

import com.accesscontrol.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExistingEntityException.class)
    public ResponseEntity<String> handleException(ExistingEntityException exception){

        String ex = exception.getMessage();
        return new ResponseEntity<String>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingUserNameAndEmailException.class)
    public ResponseEntity<ErrorResponse> handleUserNameOrEmailFoundException(ExistingUserNameAndEmailException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
