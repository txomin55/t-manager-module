package com.tmanager.module.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class OAuth2Filter implements Filter {

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

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		String refreshToken = null;
		for (Cookie c : request.getCookies()) {
			if (c.getName().equals("refresh_token")) {
				refreshToken = c.getValue();
			}
		}
		
		if (!request.getRequestURI().contains("/api/") && !request.getRequestURI().contains("/actuator")
				&& !request.getRequestURI().contains("/v2/") && !request.getRequestURI().contains("swagger")
				&& !request.getRequestURI().contains("/csrf") && !request.getRequestURI().contains(".js")
				&& !request.getRequestURI().contains("/init") && !request.getRequestURI().contains("/auth")
				&& request.getHeader("Authorization") == null && refreshToken == null) {

			String AUTH_SERVER = serverAddress + ":" + serverPort + "/" + serverPath;

			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(AUTH_SERVER + "/oauth/authorize")
					.queryParam("client_id", clientId).queryParam("response_type", "code")
					.queryParam("redirect_uri", clientRedirectUrl);

			response.sendRedirect(builder.toUriString());
		} else {
			chain.doFilter(req, res);
		}
	}
}
