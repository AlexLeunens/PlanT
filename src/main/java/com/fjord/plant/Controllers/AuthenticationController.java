package com.fjord.plant.Controllers;

import com.fjord.plant.Model.User;
import com.fjord.plant.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    // TODO: the view's name will most likely change

    @GetMapping(value = "/login")
    public ModelAndView login() {

        ModelAndView result = new ModelAndView();
        result.setViewName("loginView");
        result.addObject("user", new User());

        return result;
    }

    @PostMapping(path = "/login")
    public ModelAndView authenticate(@ModelAttribute User user, RedirectAttributes redirectAttributes) {

        // TODO : check credentials

        redirectAttributes.addFlashAttribute(user);
        return new ModelAndView("redirect:/homepage");

    }
}