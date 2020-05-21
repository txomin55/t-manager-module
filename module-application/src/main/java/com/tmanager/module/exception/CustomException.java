package com.tmanager.module.exception;

import java.util.Date;

import com.tmanager.module.exception.error.ErrorEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomException extends Exception {

	private static final long serialVersionUID = 8093367381483867991L;

	private String id;
	private Long date;
	private String[] args;

	public CustomException(ErrorEnum error) {
		super(error.getId());
		this.id = error.getId();
		this.date = new Date().getTime();
		this.args = null;
	}
	
	public CustomException(ErrorEnum error, String[] args) {
		super(error.getId());
		this.id = error.getId();
		this.date = new Date().getTime();
		this.args = args;
	}
}
