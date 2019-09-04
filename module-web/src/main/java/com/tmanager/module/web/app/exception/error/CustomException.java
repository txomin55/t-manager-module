package com.tmanager.module.web.app.exception.error;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomException extends Exception{
	
	private static final long serialVersionUID = 8093367381483867991L;

	private String id;
	
	private Long date;
	
	public CustomException(ErrorEnum error) {
		super(error.getId());
		this.id = error.getId();
		this.date = new Date().getTime();
	}
}
