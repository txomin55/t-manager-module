package com.tmanager.module.web.app.exception.error;

public enum ErrorEnum {

	TEST_ERROR("error.test");

	private String id;

	ErrorEnum(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
}
