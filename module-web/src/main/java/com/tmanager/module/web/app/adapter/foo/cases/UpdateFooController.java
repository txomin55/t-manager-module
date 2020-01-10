package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.command.FooUpdateCommand;
import com.tmanager.module.application.foo.port.UpdateFooService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooWeb;
import com.tmanager.module.web.app.adapter.foo.dto.UpdateFooWeb;
import com.tmanager.module.web.util.Oauth2DetailDecoder;
import com.tmanager.module.web.util.RequestUserDetails;

@RestController
public class UpdateFooController implements FooOperations {

    @Autowired
    private UpdateFooService fooService;

    @Autowired
    public UpdateFooController(UpdateFooService fooService) {
        this.fooService = fooService;
    }

    @PutMapping
    @ResponseBody
    public GetFooWeb createFoo(@RequestBody UpdateFooWeb fooDto, OAuth2Authentication auth) {

    	RequestUserDetails details = Oauth2DetailDecoder.getUserDecodedDetails(auth);
        
        fooService.updateFoo(new FooUpdateCommand(fooDto.getId(), fooDto.getName(), fooDto.getValue(), details.getOrganization()));
        return new GetFooWeb(fooDto.getId(), fooDto.getName(), fooDto.getValue());
    }
}
