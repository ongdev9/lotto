package com.ongdev.lotto.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice("com.ongdev.lotto.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity handleCustomException(Exception e) {
        log.error("handleCustomException throw CustomException : {}", e.getMessage());
        return new ResponseEntity(new ApiResponseMessage(HttpStatus.BAD_REQUEST,e.getMessage()).getResult(), HttpStatus.BAD_REQUEST);
    }
}