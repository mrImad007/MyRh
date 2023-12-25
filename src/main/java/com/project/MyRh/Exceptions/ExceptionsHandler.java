package com.project.MyRh.Exceptions;

import com.project.MyRh.Exceptions.Exception.ApiError;
import com.project.MyRh.Exceptions.Exception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ApiError> handleNotFound(NotFound notFound){
        ApiError apiError = new ApiError(notFound.getMessage(), "404");
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }
}
