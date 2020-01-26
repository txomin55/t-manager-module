package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.web.app.adapter.foo.FooOperations;

@RestController
public class GetFooTimeoutExcepcionController implements FooOperations {

	@Value("${module.timeoutValue}")
	private Integer timeoutValue;
	
    @GetMapping("/timeout-exception")
    public void fooMethodError() throws InterruptedException {
    	Thread.sleep(Long.valueOf(timeoutValue + 1000));
    }
}
