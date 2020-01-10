package com.tmanager.module.domain.foo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Foo {

	private String id;
	private String name;
	private String value;
	private String owner;
}
