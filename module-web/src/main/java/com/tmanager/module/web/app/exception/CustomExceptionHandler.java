package com.tmanager.module.web.app.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tmanager.module.exception.CustomException;
import com.tmanager.module.web.app.exception.error.CustomError;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    final ResponseEntity<CustomError> handleCustomException(CustomException ex, Locale locale,
            WebRequest request) {

        CustomError error = new CustomError(ex.getId(),
                messageSource.getMessage(ex.getId(), null, locale), ex.getDate());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
