package com.tmanager.module.web.app.adapter.bar.cases;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.bar.command.BarGetCommand;
import com.tmanager.module.application.bar.dto.BarDTO;
import com.tmanager.module.application.bar.port.GetBarService;
import com.tmanager.module.exception.CustomException;
import com.tmanager.module.web.app.adapter.bar.BarOperations;
import com.tmanager.module.web.app.adapter.bar.dto.GetBarWeb;

@RestController
public class GetBarController implements BarOperations {

    @Autowired
    private GetBarService getBarService;

    @Autowired
    public GetBarController(GetBarService getBarService) {
        this.getBarService = getBarService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize("#oauth2.hasScope('get-bar')")
    public GetBarWeb getBar(@PathVariable @NotNull(message = "error.validation_not_null") String id) throws CustomException {
            	
    	BarDTO bar = getBarService.getBar(new BarGetCommand(id));
    	
        return new GetBarWeb(bar.getId(), bar.getName());
    }
}
