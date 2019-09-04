package com.tmanager.module.web.app.foo;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.api.FooService;
import com.tmanager.module.application.shared.FooDTO;
import com.tmanager.module.web.app.exception.error.CustomException;
import com.tmanager.module.web.app.exception.error.ErrorEnum;

@RestController
@RequestMapping("/foo")
public class FooController {

    @Autowired
    private FooService fooService;
    
    @Autowired
    private MessageSource messageSource;

    @Autowired
    public FooController(FooService fooService) {
        this.fooService = fooService;
    }
    
    @GetMapping
    public List<FooDTO> get() {
    	return fooService.getFoo();
    }
    
    @PostMapping
    public void createFoo(@RequestBody FooDTO fooDto) {
    	fooService.createFoo(fooDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFoo(@PathVariable int id) {
    	fooService.deleteFoo(id);
    }

    @GetMapping("/exception")
    public void fooMethodError() throws CustomException {
    	throw new CustomException(ErrorEnum.TEST_ERROR);
    }
    
    @GetMapping("/fooI18nSample")
    public String fooMethodI18n(Locale locale) {
    	return messageSource.getMessage("hello", null, locale);
    }
}
