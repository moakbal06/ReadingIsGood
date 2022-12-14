package com.onur.reading.controller.advice;

import com.onur.reading.exception.BookNotFoundException;
import com.onur.reading.exception.BusinessException;
import com.onur.reading.exception.CustomerNotFoundException;
import com.onur.reading.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControlAdvice {

    @ExceptionHandler({CustomerNotFoundException.class, BookNotFoundException.class, OrderNotFoundException.class})
    public ResponseEntity handleGeneralException(BusinessException e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error_code", e.getErrorCode());
        body.put("error_message", e.getErrorMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handleBusinessException(BusinessException e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error_code", e.getErrorCode());
        body.put("error_message", e.getErrorMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
