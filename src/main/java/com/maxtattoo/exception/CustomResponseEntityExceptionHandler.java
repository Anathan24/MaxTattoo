package com.maxtattoo.exception;

import com.maxtattoo.utils.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponseMessage> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ExceptionResponseMessage exceptionResponseMessage = new ExceptionResponseMessage(
                DateUtils.getNow(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponseMessage, HttpStatus.NOT_FOUND);
    }
}
