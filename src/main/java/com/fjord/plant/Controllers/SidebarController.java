package com.fjord.plant.Controllers;

import com.fjord.plant.Model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SidebarController {

	private ModelAndView redirect(@ModelAttribute User user, String viewName) {

		ModelAndView result = new ModelAndView();
		result.addObject(user);
		result.setViewName(viewName);

		return result;
	}

	@GetMapping(value = { "/accueil", "" })
	public ModelAndView displayHomepage(@ModelAttribute User user) {
		return redirect(user, "homepageView");
	}

	@GetMapping(value = "/calendrier")
	public ModelAndView displayCalendrier(@ModelAttribute User user) {
		return redirect(user, "Calendrier");
	}

	@GetMapping(value = "/jardin")
	public ModelAndView displayJardin(@ModelAttribute User user) {
		return redirect(user, "Jardin");
	}

	@GetMapping(value = "/arrosage")
	public ModelAndView displayArrosage(@ModelAttribute User user) {
		return redirect(user, "Arrosage");
	}

	@GetMapping(value = "/formation")
	public ModelAndView displayFormation(@ModelAttribute User user) {
		return redirect(user, "Formation");
	}

	@GetMapping(value = "/compte")
	public ModelAndView displayCompte(@ModelAttribute User user) {
		return redirect(user, "Compte");
	}
	
	@GetMapping(value = "/infos")
	public ModelAndView displayInfos(@ModelAttribute User user) {
		return redirect(user, "Infos");
	}

}