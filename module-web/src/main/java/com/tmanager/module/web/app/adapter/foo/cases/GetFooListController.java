package com.tmanager.module.web.app.adapter.foo.cases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.port.GetFooListService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooWeb;

@RestController
public class GetFooListController implements FooOperations {

    @Autowired
    private GetFooListService getFooListService;

    @Autowired
    public GetFooListController(GetFooListService getFooListService) {
        this.getFooListService = getFooListService;
    }

    @GetMapping
    public List<GetFooWeb> getFoos() {    	
        return getFooListService.getFoo().stream()
            .map(foo -> new GetFooWeb(foo.getId(), foo.getName(), foo.getValue()))
            .collect(Collectors.toList());
    }
}
