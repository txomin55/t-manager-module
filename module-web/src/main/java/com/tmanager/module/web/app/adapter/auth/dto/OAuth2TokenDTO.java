package com.tmanager.module.web.app.adapter.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OAuth2TokenDTO {

	private String access_token;
	private String refresh_token;
	private int expires_in;
}
