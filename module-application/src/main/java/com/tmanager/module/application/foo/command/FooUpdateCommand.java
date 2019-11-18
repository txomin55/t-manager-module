package com.tmanager.module.application.foo.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FooUpdateCommand {

	private Integer id;
	private String name;
	private String value;
}
