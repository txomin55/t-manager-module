package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.exception.CustomException;
import com.tmanager.module.exception.error.ErrorEnum;
import com.tmanager.module.web.app.adapter.foo.FooOperations;

@RestController
public class GetExcepcionController implements FooOperations {

    @GetMapping("/exception")
    public void fooMethodError() throws CustomException {
        throw new CustomException(ErrorEnum.TEST_ERROR);
    }
}
