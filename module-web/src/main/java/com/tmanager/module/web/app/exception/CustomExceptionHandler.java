package com.tmanager.module.web.app.exception;

import java.net.ConnectException;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InsufficientScopeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tmanager.module.exception.CustomException;
import com.tmanager.module.web.app.exception.error.CustomError;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Value("${module.timeoutValue}")
	private String timeoutValue;
	
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    final ResponseEntity<CustomError> handleCustomException(CustomException ex, Locale locale,
            WebRequest request) {

        CustomError error = new CustomError(ex.getId(),
                messageSource.getMessage(ex.getId(), ex.getArgs(), locale), ex.getDate());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InterruptedException.class)
    @ResponseBody
    final ResponseEntity<CustomError> handleInterruptedException(InterruptedException ex, Locale locale,
    		WebRequest request) {
    	
    	CustomError error = new CustomError(String.valueOf(HttpStatus.REQUEST_TIMEOUT.value()),
    			messageSource.getMessage("error.request_timeout", new String[] {timeoutValue}, locale), new Date().getTime());
    	return new ResponseEntity<>(error, HttpStatus.REQUEST_TIMEOUT);
    }
    
	@ExceptionHandler(ConnectException.class)
	@ResponseBody
	final ResponseEntity<CustomError> handleConnectException(ConnectException ex, Locale locale,
			WebRequest request) {
		
		CustomError error = new CustomError(String.valueOf(HttpStatus.NO_CONTENT.value()),
				messageSource.getMessage("error.module_not_available", new String[] { request.getContextPath() }, locale),
				new Date().getTime());
		return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
	}

    @ExceptionHandler(InsufficientScopeException.class)
    @ResponseBody
    final ResponseEntity<CustomError> handleInsufficientScopeException(InsufficientScopeException ex, Locale locale,
    		WebRequest request) {
    	    	
    	CustomError error = new CustomError(String.valueOf(HttpStatus.FORBIDDEN.value()),
    			messageSource.getMessage("error.insufficient_scope", new String[] {ex.getAdditionalInformation().get("scope")}, locale), new Date().getTime());
    	return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }
    
    @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

    	StringBuffer errorString = new StringBuffer();
    	errorString.append(messageSource.getMessage("error.validation_errors", null, request.getLocale()));
    	
    	ex.getBindingResult().getFieldErrors().stream().map(e -> messageSource.getMessage(e.getDefaultMessage(), new String[] {e.getField()}, request.getLocale())).forEach(e -> errorString.append("\n" + e));
    	
        CustomError error = new CustomError(String.valueOf(HttpStatus.BAD_REQUEST.value()), errorString.toString(), new Date().getTime());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
