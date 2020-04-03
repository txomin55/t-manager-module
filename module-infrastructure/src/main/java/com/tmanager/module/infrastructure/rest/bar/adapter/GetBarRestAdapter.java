package com.tmanager.module.infrastructure.rest.bar.adapter;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tmanager.module.domain.bar.model.Bar;
import com.tmanager.module.domain.bar.port.GetBarPersistancePort;

public class GetBarRestAdapter implements GetBarPersistancePort{

	@Value("${module.external.bar.url}")
	private String barPath;
	
	@Override
	public Bar getBar(String id, Map<String, String> aux) {
		
		final String uri = barPath + "/" + id;

	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		aux.keySet().stream().forEach(k -> headers.set(k, aux.get(k)));
	    
	    HttpEntity<String> entity = new HttpEntity<String>("paramters", headers);

	    ResponseEntity<Bar> bar = restTemplate.exchange(uri, HttpMethod.GET, entity, Bar.class);
	    
	    return bar.getBody();
	}
}
