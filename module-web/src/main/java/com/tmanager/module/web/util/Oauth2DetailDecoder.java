package com.tmanager.module.web.util;

import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class Oauth2DetailDecoder {

	static public RequestUserDetails getUserDecodedDetails(OAuth2Authentication auth) {
		
		OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) auth.getDetails();
        Map<String, Object> details = (Map<String, Object>) oauthDetails.getDecodedDetails();
        
		return new RequestUserDetails(details.get("id").toString(), details.get("full_name").toString(), details.get("organization").toString());
	}
}
