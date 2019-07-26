package com.tmanager.module.web.app.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tmanager.module.web.app.exception.error.CustomError;
import com.tmanager.module.web.app.exception.error.CustomException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
    
	@Autowired
	private MessageSource messageSource;
	
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public CustomError handleNoRecordFoundException(CustomException ex) {
    	
    	return new CustomError(ex.getId(), messageSource.getMessage(ex.getId(), null, LocaleContextHolder.getLocale()), ex.getDate()); 
    }
    
}
