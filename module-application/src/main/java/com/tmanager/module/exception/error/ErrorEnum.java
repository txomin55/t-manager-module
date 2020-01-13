package com.tmanager.module.exception.error;

public enum ErrorEnum {

	TEST_ERROR("error.test"),
	UNAUTHORIZED_RESOURCE_ERROR("error.unauthorized_resource");

	private String id;

	ErrorEnum(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
}
