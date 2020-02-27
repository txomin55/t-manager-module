package com.tmanager.module.application.bar.command;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BarGetCommand {

	private String id;
	private Map<String, String> aux;
}
