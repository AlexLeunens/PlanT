package com.fjord.plant.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    // TODO: the view's name will most likely change

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("loginView");
    }

    @PostMapping(path = "/login")
    public ModelAndView authenticate(@RequestParam String email, @RequestParam String password) {

        return new ModelAndView("redirect:homepage");
    }
}