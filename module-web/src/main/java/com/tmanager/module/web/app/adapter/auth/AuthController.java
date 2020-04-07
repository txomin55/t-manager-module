package com.tmanager.module.web.app.adapter.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.tmanager.module.web.app.adapter.auth.dto.OAuth2TokenDTO;

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
	
	private RestTemplate restTemplate;

	public AuthController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	@GetMapping("/authorize")
	public String authorize() {

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
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(AUTH_SERVER + "/token")
				.queryParam("grant_type", "refresh_token").queryParam("client_id", clientId)
				.queryParam("client_secret", clientSecret)
				.queryParam("refresh_token", refresh_token);

		OAuth2TokenDTO oauthObj =
				restTemplate.getForObject(builder.toUriString(), OAuth2TokenDTO.class);

		return oauthObj;
	}
}
