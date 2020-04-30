package com.fjord.plant.Controllers;

import com.fjord.plant.Model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

	@GetMapping(value = "/homepage")
	public ModelAndView displayHomepage(@ModelAttribute User user) {

		ModelAndView result = new ModelAndView();
		result.addObject(user);
		result.setViewName("homepageView");

		return result;
	}

	@GetMapping(value = "/jardin")
	public ModelAndView displayJardin(@ModelAttribute User user) {

		ModelAndView result = new ModelAndView();
		result.addObject(user);
		result.setViewName("jardin");

		return result;
	}

	@GetMapping(value = "/arrosage")
	public ModelAndView displayArrosage(@ModelAttribute User user) {

		ModelAndView result = new ModelAndView();
		result.addObject(user);
		result.setViewName("Arrosage");

		return result;
	}

	@GetMapping(value = "/moncompte")
	public ModelAndView displayMonCompte(@ModelAttribute User user) {

		ModelAndView result = new ModelAndView();
		result.addObject(user);
		result.setViewName("moncompte");

		return result;
	}
}