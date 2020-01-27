package com.tmanager.module.web.app.adapter.foo.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateFooWeb {

	@NotNull(message = "error.validation_not_null")
	private String id;
	private String name;
	private String value;
}
