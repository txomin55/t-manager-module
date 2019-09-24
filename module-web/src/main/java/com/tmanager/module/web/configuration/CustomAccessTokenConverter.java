package com.tmanager.module.web.configuration;

import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import io.micrometer.core.instrument.util.IOUtils;

@Component
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {
 
    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        OAuth2Authentication authentication = super.extractAuthentication(claims);
        authentication.setDetails(claims);
        return authentication;
    }
}