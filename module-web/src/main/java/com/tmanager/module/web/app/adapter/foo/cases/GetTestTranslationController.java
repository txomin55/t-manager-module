package com.tmanager.module.web.app.adapter.foo.cases;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.web.app.adapter.foo.FooOperations;

@RestController
public class GetTestTranslationController implements FooOperations{

    @Autowired
    private MessageSource messageSource;
    
    @GetMapping("/fooI18nSample")
    public String fooMethodI18n(Locale locale) {
    	return messageSource.getMessage("hello", null, locale);
    }
}
