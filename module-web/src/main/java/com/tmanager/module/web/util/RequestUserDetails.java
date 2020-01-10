package com.tmanager.module.web.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequestUserDetails {

	private String id;
	private String fullName;
	private String organization;
}
