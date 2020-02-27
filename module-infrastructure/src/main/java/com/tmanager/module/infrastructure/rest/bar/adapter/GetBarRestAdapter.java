package com.tmanager.module.infrastructure.rest.bar.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.tmanager.module.domain.bar.model.Bar;
import com.tmanager.module.domain.bar.port.GetBarPersistancePort;

public class GetBarRestAdapter implements GetBarPersistancePort{

	@Value("${module.external.bar.url}")
	private String barPath;
	
	@Override
	public Bar getBar(String id) {
		
		final String uri = barPath + "/" + id;

	    RestTemplate restTemplate = new RestTemplate();

	    return restTemplate.getForObject(uri, Bar.class);
	}
}
