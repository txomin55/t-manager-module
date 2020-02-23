package com.tmanager.module.web.app.adapter.foo.cases;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.command.FooDeleteCommand;
import com.tmanager.module.application.foo.port.DeleteFooService;
import com.tmanager.module.exception.CustomException;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.util.Oauth2DetailDecoder;
import com.tmanager.module.web.util.RequestUserDetails;

@RestController
public class DeleteFooController implements FooOperations {

    @Autowired
    private DeleteFooService deleteFooService;

    @Autowired
    public DeleteFooController(DeleteFooService deleteFooService) {
        this.deleteFooService = deleteFooService;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#oauth2.hasScope('delete-foo')")
    public void deleteFoo(@PathVariable @NotNull(message = "error.validation_not_null") String id, OAuth2Authentication auth) throws CustomException {

    	RequestUserDetails details = Oauth2DetailDecoder.getUserDecodedDetails(auth);

        deleteFooService.deleteFoo(new FooDeleteCommand(id, details.getOrganization()));
    }
}
