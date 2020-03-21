package com.tmanager.module.infrastructure.rest.bar;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.tmanager.module.domain.bar.model.Bar;

@Ignore
@RunWith(SpringRunner.class)
@TestPropertySource(locations={"classpath:application.yml"})
@ContextConfiguration(initializers={ConfigFileApplicationContextInitializer.class})
public class GetBarTest{
	
	@Value("${module.external.bar.url}")
	private String barPath;
	
	@Test
	public void getBar() {
		
		String id = "1";
		
		final String uri = barPath + "/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer Valid-token");
	    headers.set("Accept-language", "es");
	    
	    HttpEntity<String> entity = new HttpEntity<String>("paramters", headers);
	    
	    ResponseEntity<Bar> bar = restTemplate.exchange(uri, HttpMethod.GET, entity, Bar.class);
	    
	    bar.getBody();
	}
}
