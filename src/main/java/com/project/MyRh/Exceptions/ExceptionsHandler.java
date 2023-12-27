package com.project.MyRh.Exceptions;

import com.project.MyRh.Exceptions.Exception.*;
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

    @ExceptionHandler(OperationFailed.class)
    public ResponseEntity<ApiError> handleOperationFailed(OperationFailed operationFailed) {
        ApiError apiError = new ApiError(operationFailed.getMessage(), "400"); // Use "400" for Bad Request
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<ApiError> handleInvalidCredentials(InvalidCredentials invalidCredentials){
        ApiError apiError = new ApiError(invalidCredentials.getMessage(), "403");
        return new ResponseEntity<ApiError>(apiError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AlreadyExisting.class)
    public ResponseEntity<ApiError> handleAlreadyExisting(AlreadyExisting alreadyExisting){
        ApiError apiError = new ApiError(alreadyExisting.getMessage(), "409");
        return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
    }
}
