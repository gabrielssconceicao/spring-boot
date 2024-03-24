package com.algaworks.awpag.awpagapi.api.controller.exceptionHandler;

import com.algaworks.awpag.awpagapi.domain.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// é  capaz de capturar as exceçoes de todos os controllers
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> capture(BusinessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
