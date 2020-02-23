package com.tmanager.module.web.app.adapter.foo.cases;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.command.FooCreateCommand;
import com.tmanager.module.application.foo.port.CreateFooService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.CreateFooWeb;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooWeb;
import com.tmanager.module.web.util.Oauth2DetailDecoder;
import com.tmanager.module.web.util.RequestUserDetails;

@RestController
public class CreateFooController implements FooOperations {

    @Autowired
    private CreateFooService fooService;

    @Autowired
    public CreateFooController(CreateFooService fooService) {
        this.fooService = fooService;
    }

    @PostMapping
    @PreAuthorize("#oauth2.hasScope('create-foo')")
    public GetFooWeb createFoo(@Valid @RequestBody CreateFooWeb fooDto, OAuth2Authentication auth) {

        RequestUserDetails details = Oauth2DetailDecoder.getUserDecodedDetails(auth);
        
        String id = fooService.createFoo(new FooCreateCommand(fooDto.getName(), fooDto.getValue(), details.getOrganization()));
        return new GetFooWeb(id, fooDto.getName(), fooDto.getValue());
    }
}
