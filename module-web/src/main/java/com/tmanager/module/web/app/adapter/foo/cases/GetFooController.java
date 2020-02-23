package com.tmanager.module.web.app.adapter.foo.cases;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.command.FooGetCommand;
import com.tmanager.module.application.foo.dto.FooDTO;
import com.tmanager.module.application.foo.port.GetFooService;
import com.tmanager.module.exception.CustomException;
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

    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize("#oauth2.hasScope('get-foo')")
    public GetFooWeb getFoo(@PathVariable @NotNull(message = "error.validation_not_null") String id, OAuth2Authentication auth) throws CustomException {
        
    	RequestUserDetails details = Oauth2DetailDecoder.getUserDecodedDetails(auth);
    	
    	FooDTO foo = getFooService.getFoo(new FooGetCommand(id, details.getOrganization()));
    	
        return new GetFooWeb(foo.getId(), foo.getName(), foo.getValue());
    }
}
