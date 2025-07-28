package org.suhariki.inscription.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("home")
@Controller
public class HomeController {

    @GetMapping
    public String ShowHome() {
        return "home";
    }

//    @PostMapping
//    public String StartGame() {
//        return "main";
//    }
}
