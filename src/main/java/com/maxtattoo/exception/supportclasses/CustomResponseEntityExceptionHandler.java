package com.maxtattoo.exception.supportclasses;

import com.maxtattoo.exception.GenericException;
import com.maxtattoo.utils.DateUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public final ResponseEntity<ExceptionResponseMessage> handleResourceNotFoundException(GenericException exception, WebRequest request) {
        ExceptionResponseMessage exceptionResponseMessage = new ExceptionResponseMessage(
                DateUtils.getNow(),
                exception.getStatus().value(),
                exception.getStatus().getReasonPhrase(),
                exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponseMessage, exception.getStatus());
    }
}
