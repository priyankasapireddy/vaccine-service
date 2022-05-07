package com.curelight.vaccineservice.exception;

import com.curelight.vaccineservice.dto.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class VaccineExceptionHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(value
            = { SQLIntegrityConstraintViolationException.class })
    protected ResponseEntity<ErrorMessage> handleSqlException(
            SQLIntegrityConstraintViolationException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value
            = { Exception.class })
    protected ResponseEntity<ErrorMessage> handleOtherException(
            Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
