package com.tmanager.module.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePathRedirection() {
        return "redirect:auth/authorizeApp";
    }

    @GetMapping("/init")
    public String homePathInit() {
        return "forward:/index.html";
    }
    
    @RequestMapping("{?:(?:(?!api|static|\\.).)*}/**")
    public String redirectApi() {     
        return "forward:/index.html";
    } 
}
