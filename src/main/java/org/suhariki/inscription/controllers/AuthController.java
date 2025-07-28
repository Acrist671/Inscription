package org.suhariki.inscription.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.suhariki.inscription.repositories.MainRepository;

@RequestMapping("auth")
@Controller
public class AuthController {
    private final MainRepository mainRepository;

    @Autowired
    public AuthController(final MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @GetMapping
    public String ShowAuthentication(Model model) {
        return "auth";
    }

    @PostMapping
    public String CreateAuthentication(@RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       Model model) {
        if (!mainRepository.CheckAuthentication(username, password)) {
            model.addAttribute("error", "Invalid username or password");
            model.addAttribute("username", username);
            return "auth";
        }
        return "redirect:/home";
    }

}
