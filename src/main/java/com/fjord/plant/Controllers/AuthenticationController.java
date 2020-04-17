package com.fjord.plant.Controllers;

import javax.validation.Valid;

import com.fjord.plant.Model.User;
import com.fjord.plant.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    // TODO: the view's name will most likely change

    @GetMapping(value = "/login")
    public ModelAndView login() {

        ModelAndView result = new ModelAndView();
        result.setViewName("loginView");
        result.addObject("user", new User());

        return result;
    }

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView result = new ModelAndView();
        User user = new User();
        result.addObject("user", user);
        result.setViewName("register");
        return result;
    }

    @PostMapping(value = "/register")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {

        ModelAndView result = new ModelAndView();

        User userExists = userService.findUserByName(user.getName());
        if (userExists != null) {
            bindingResult.rejectValue("name", "error.user",
                    "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            result.setViewName("register");
        } else {
            userService.saveUser(user);
            result.addObject("successMessage", "User has been registered successfully");
            result.addObject("user", new User());
            result.setViewName("register");
        }

        return result;
    }
}