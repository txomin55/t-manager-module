package com.tmanager.module.application.foo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FooListDTO {

	private String id;
	private String name;
	private String value;
	private String owner;
}
