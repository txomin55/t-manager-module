package com.tmanager.module.web.configuration;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {

	@Value("${trust.store.classpath}")
	private Resource trustStore;

	@Value("${trust.store.password}")
	private String trustStorePassword;

	@Override
	public void customize(RestTemplate restTemplate) {

		SSLContext sslContext = null;
		try {
			sslContext = new SSLContextBuilder()
					.loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray()).build();
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | CertificateException
				| IOException e) {
			
			e.printStackTrace();
		}
		
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
		
		HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
		
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

		restTemplate.setRequestFactory(factory);
	}
}
