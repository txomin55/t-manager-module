package com.tmanager.module.application.foo.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FooGetCommand {

	private String id;
	private String owner;
}
