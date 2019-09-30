package com.tmanager.module.web.app.adapter.foo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetFooWeb {

	private int id;
	private String name;
	private String value;
}