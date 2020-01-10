package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.command.FooGetCommand;
import com.tmanager.module.application.foo.dto.FooDTO;
import com.tmanager.module.application.foo.port.GetFooService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooWeb;
import com.tmanager.module.web.util.Oauth2DetailDecoder;
import com.tmanager.module.web.util.RequestUserDetails;

@RestController
public class GetFooController implements FooOperations {

    @Autowired
    private GetFooService getFooService;

    @Autowired
    public GetFooController(GetFooService getFooService) {
        this.getFooService = getFooService;
    }

    @GetMapping
    @ResponseBody
    public GetFooWeb getFoos(String id, OAuth2Authentication auth) {
        
    	RequestUserDetails details = Oauth2DetailDecoder.getUserDecodedDetails(auth);
    	
    	FooDTO foo = getFooService.getFoo(new FooGetCommand(id, details.getOrganization()));
    	
        return new GetFooWeb(foo.getId(), foo.getName(), foo.getValue());
    }
}
