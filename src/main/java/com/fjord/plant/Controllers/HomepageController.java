package com.fjord.plant.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

    // TODO: the view's name will most likely change

    @GetMapping(value = "/homepage")
    public ModelAndView login() {
        return new ModelAndView("homepageView");
    }
}