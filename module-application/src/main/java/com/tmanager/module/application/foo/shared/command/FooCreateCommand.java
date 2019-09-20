package com.tmanager.module.application.foo.shared.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FooCreateCommand {

	private int id;
	private String name;
}
