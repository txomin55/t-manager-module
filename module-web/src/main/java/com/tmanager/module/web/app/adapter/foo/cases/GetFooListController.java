package com.tmanager.module.web.app.adapter.foo.cases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.port.GetFooListService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooListWeb;
import com.tmanager.module.web.util.Oauth2DetailDecoder;
import com.tmanager.module.web.util.RequestUserDetails;

@RestController
public class GetFooListController implements FooOperations {

    @Autowired
    private GetFooListService getFooListService;

    @Autowired
    public GetFooListController(GetFooListService getFooListService) {
        this.getFooListService = getFooListService;
    }

    @GetMapping("/list")
    public List<GetFooListWeb> getFoos(OAuth2Authentication auth) {   
        
    	RequestUserDetails details = Oauth2DetailDecoder.getUserDecodedDetails(auth);
        
        return getFooListService.getFoo(details.getOrganization()).stream()
            .map(foo -> new GetFooListWeb(foo.getId(), foo.getName(), foo.getValue()))
            .collect(Collectors.toList());
    }
}
