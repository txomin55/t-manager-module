package com.tmanager.module.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePathRedirection() {
        return "redirect:auth/authorize";
    }

    @GetMapping("/init")
    public String homePathInit() {
        return "forward:/index.html";
    }
    
    /*
    "/init/**",
    "/actuator/**",
    "/auth/**",
    "/favicon.ico",
    "/static/*",
    "/module.js",
    "/v2/api-docs",
    "/configuration/ui",
    "/swagger-resources/**",
    "/configuration/security",
    "/swagger-ui.html",
    "/webjars/**"
    */
    @GetMapping("^(?!\\/api\\/)(?!\\/swagger)(?!\\/static)(?!\\/v2)(?!\\/configuration)(?!\\/webjars)(?!\\/actuator).*$")
    public String redirectApi() {     
        return "forward:/index.html";
    } 
}
