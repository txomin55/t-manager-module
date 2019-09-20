package com.tmanager.module.web.app.adapter.foo.cases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.port.GetFooListService;
import com.tmanager.module.application.foo.shared.dto.FooDTO;
import com.tmanager.module.web.app.adapter.foo.FooOperations;

@RestController
public class GetFooListController implements FooOperations{

    @Autowired
    private GetFooListService getFooListService;
    
    @Autowired
    public GetFooListController(GetFooListService getFooListService) {
        this.getFooListService = getFooListService;
    }
    
    @GetMapping
    public List<FooDTO> get() {
    	return getFooListService.getFoo();
    }
}
