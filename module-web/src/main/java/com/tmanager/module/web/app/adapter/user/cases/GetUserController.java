package com.tmanager.module.web.app.adapter.user.cases;

import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.web.app.adapter.user.UserOperations;

@RestController
public class GetUserController implements UserOperations {

	@GetMapping
	@ResponseBody
	public Map<String, Object> getUserData(OAuth2Authentication auth){
		
		OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) auth.getDetails();

	  	return (Map<String, Object>) oauthDetails.getDecodedDetails();
	}
}
