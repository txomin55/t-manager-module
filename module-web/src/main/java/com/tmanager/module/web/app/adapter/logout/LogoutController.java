package com.tmanager.module.web.app.adapter.logout;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogoutController {

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

	@Value("${spring.application.name}")
	private String applicationName;

	@GetMapping("/api/exit")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		String[] urlParts = request.getHeader("referer").split("/");
		String homePath = urlParts[0] + "//" + urlParts[2] + "/" + applicationName;

		String refreshToken = null;
		if (request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("refresh_token")) {
					refreshToken = c.getValue();
					c.setMaxAge(0);
				}
			}
		}

		return serverAddress + ":" + serverPort + "/" + serverPath + "/exit?redirection=" + homePath + "&refreshToken="
				+ refreshToken;
	}
}
