package com.example.scheduler2.handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)//valid 위반 통합에러 처리기,  나중에 분리예정
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Global Error: Required values must not blank.");
    }
    @ExceptionHandler(ConstraintViolationException.class)//validated 위반 통합 에러 처리기, 나중에 분리 예정
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body("Global Error: Required values must have proper value.");
    }
}
