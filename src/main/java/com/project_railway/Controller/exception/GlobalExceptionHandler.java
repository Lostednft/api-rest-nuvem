package com.project_railway.Controller.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity handlerNoContent(IllegalArgumentException illegalException)
    {
        return new ResponseEntity(illegalException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity handlerNotFound(NoSuchElementException noSuchException)
    {
        return new ResponseEntity("This user id doesn't exist.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    private ResponseEntity handlerUnexpectedError(Throwable throwable)
    {
        var messageUnexpected = "Unexpected serve error, see the logs";

        logger.error(messageUnexpected, throwable);
        return new ResponseEntity(messageUnexpected, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
