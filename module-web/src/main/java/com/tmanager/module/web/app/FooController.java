package com.tmanager.module.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.api.FooService;
import com.tmanager.module.application.shared.FooDTO;
import com.tmanager.module.web.app.exception.error.CustomException;
import com.tmanager.module.web.app.exception.error.ErrorEnum;

@RestController
@RequestMapping("/foo")
public class FooController {

    private FooService fooService;
    
    @Autowired
    private MessageSource messageSource;

    @Autowired
    public FooController(FooService fooService) {
        this.fooService = fooService;
    }
    
    @GetMapping("/action")
    public void fooMethod() {
    	FooDTO fooDto = new FooDTO();
    	fooDto.setId(1);
    	fooService.fooMethod(fooDto);
    }
    
    @GetMapping("/fooErrorSample")
    public void fooMethodError() throws CustomException {
    	throw new CustomException(ErrorEnum.TEST_ERROR);
    }
    
    @GetMapping("/fooI18nSample")
    public String fooMethodI18n() {
    	return messageSource.getMessage("hello", null, LocaleContextHolder.getLocale());
    }
}
