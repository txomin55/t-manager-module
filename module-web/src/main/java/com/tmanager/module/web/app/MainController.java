package com.tmanager.module.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/js-file")
    public String homeJSFile() {
    	return "forward:/index.html";
    }
}
