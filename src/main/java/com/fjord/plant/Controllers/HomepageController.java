package com.fjord.plant.Controllers;

import com.fjord.plant.Model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

    // TODO: the view's name will most likely change

    @GetMapping(value = "/homepage")
    public ModelAndView display(@ModelAttribute User user) {

        ModelAndView result = new ModelAndView();
        result.addObject(user);
        result.setViewName("homepageView");

        return result;
    }
}