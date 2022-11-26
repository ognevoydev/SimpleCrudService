package com.ognevoydev.spring.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        return "Home page";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "About page";
    }


}