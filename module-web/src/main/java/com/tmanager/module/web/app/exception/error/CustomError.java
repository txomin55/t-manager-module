package com.tmanager.module.web.app.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomError {

	private String id;
	
	private String msg;
	
	private Long date;
}
