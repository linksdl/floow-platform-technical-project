package com.floow.challenge.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        logger.error("Server occur error:", e);
        return new ResponseEntity<>("Internal server error!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<BusinessException> businessExceptionHandler(HttpServletRequest httpServletRequest, BusinessException e) {
        logger.error("Some wrong occurring, code: {}, message:{}", e.getCode(), e.getMessage());
        return new ResponseEntity<BusinessException>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<BusinessException>> handle(MethodArgumentNotValidException ex) {
        List<BusinessException> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            BusinessException e = BusinessException.builder()
                    .code(ExceptionEnum.INVALID_DATA_FORMAT_ERROR.getCode())
                    .message(ExceptionEnum.INVALID_DATA_FORMAT_ERROR.getMessage()+","+ errorMessage)
                    .build();
            errors.add(e);
        });
        return new ResponseEntity<List<BusinessException>>(errors, HttpStatus.BAD_REQUEST);
    }





}
