package com.updownftw.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // DefaultException Hanlder
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> anyException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(HttpStatus.BAD_REQUEST, "Sorry, something went wrong on the servver"));
    }

    // CustomizedException Handler
    @ExceptionHandler(NoSuchFriendExistsException.class)
    public ResponseEntity<ErrorMessage> noSuchFriendExistsException(NoSuchFriendExistsException ex) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
