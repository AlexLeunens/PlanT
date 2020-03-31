package com.fjord.plant.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {
        return "Hello World !";
    }

    @RequestMapping(value = "/bar", method = RequestMethod.GET)
    public ModelAndView bar() {
        return new ModelAndView("bar");
    }
}