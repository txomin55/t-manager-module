package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.exception.error.CustomException;
import com.tmanager.module.web.app.exception.error.ErrorEnum;

@RestController
public class GetExcepcionController implements FooOperations {

    @GetMapping("/exception")
    public void fooMethodError() throws CustomException {
        throw new CustomException(ErrorEnum.TEST_ERROR);
    }
}
