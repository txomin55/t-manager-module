package com.tmanager.module.web.app.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.tmanager.module.web.app.auth.dto.OAuth2TokenDTO;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Value("${module.oauth.clientId}")
	private String clientId;

	@Value("${module.oauth.clientSecret}")
	private String clientSecret;

	@Value("${module.oauth.server.path}")
	private String serverPath;

	@Value("${module.oauth.server.port}")
	private String serverPort;

	@Value("${module.oauth.server.address}")
	private String serverAddress;

	@Value("${module.oauth.clientRedirectUrl}")
	private String clientRedirectUrl;
	
	@GetMapping("/authorizeApp")
	public String authorizeApp() {

		String AUTH_SERVER = serverAddress + ":" + serverPort + "/" + serverPath + "/oauth";
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(AUTH_SERVER + "/authorize")
				.queryParam("client_id", clientId).queryParam("response_type", "code")
				.queryParam("redirect_uri", clientRedirectUrl);

		return "redirect:" + builder.toUriString();
	}

	@GetMapping("/getToken")
	@ResponseBody
	public OAuth2TokenDTO getToken(@RequestParam String code) {

		String AUTH_SERVER = serverAddress + ":" + serverPort + "/" + serverPath + "/oauth";
		
		RestTemplate restTemplate = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(AUTH_SERVER + "/token")
				.queryParam("grant_type", "authorization_code").queryParam("client_id", clientId)
				.queryParam("client_secret", clientSecret)
				.queryParam("redirect_uri", clientRedirectUrl).queryParam("code", code);

		OAuth2TokenDTO oauthObj =
				restTemplate.postForObject(builder.toUriString(), null, OAuth2TokenDTO.class);

		return oauthObj;
	}

	@GetMapping("/refreshToken")
	@ResponseBody
	public OAuth2TokenDTO refreshToken(@RequestParam String refresh_token) {

		String AUTH_SERVER = serverAddress + ":" + serverPort + "/" + serverPath + "/oauth";
		
		RestTemplate restTemplate = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(AUTH_SERVER + "/token")
				.queryParam("grant_type", "refresh_token").queryParam("client_id", clientId)
				.queryParam("client_secret", clientSecret)
				.queryParam("refresh_token", refresh_token);

		OAuth2TokenDTO oauthObj =
				restTemplate.getForObject(builder.toUriString(), OAuth2TokenDTO.class);

		return oauthObj;
	}

	@GetMapping("/getUserData")
	@ResponseBody
	public Map<String, Object> getUserData(OAuth2Authentication auth){
		
		OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) auth.getDetails();

	  	return (Map<String, Object>) oauthDetails.getDecodedDetails();
	}
}
