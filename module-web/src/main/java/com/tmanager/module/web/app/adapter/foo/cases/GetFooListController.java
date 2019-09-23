package com.tmanager.module.web.app.adapter.foo.cases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.port.GetFooListService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.FooWeb;

@RestController
public class GetFooListController implements FooOperations {

    @Autowired
    private GetFooListService getFooListService;

    @Autowired
    public GetFooListController(GetFooListService getFooListService) {
        this.getFooListService = getFooListService;
    }

    @GetMapping
    public List<FooWeb> getFoos() {    	
        return getFooListService.getFoo().stream()
            .map(foo -> new FooWeb(foo.getId(), foo.getName()))
            .collect(Collectors.toList());
    }
}
