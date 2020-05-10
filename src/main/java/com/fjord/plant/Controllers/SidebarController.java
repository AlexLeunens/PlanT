package com.fjord.plant.Controllers;

import com.fjord.plant.Model.User;
import com.fjord.plant.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SidebarController {

	@Autowired
	private UserService userService;

	private ModelAndView redirect(String viewName) {
		ModelAndView result = new ModelAndView();

		User user = userService.getCurrentUser();
		result.addObject(user);
		result.setViewName(viewName);

		return result;
	}

	@GetMapping(value = { "/accueil", "" })
	public ModelAndView displayHomepage() {
		return redirect("homepageView");
	}

	@GetMapping(value = "/calendrier")
	public ModelAndView displayCalendrier() {
		return redirect("Calendrier");
	}

	@GetMapping(value = "/jardin")
	public ModelAndView displayJardin() {
		return redirect("Jardin");
	}

	@GetMapping(value = "/arrosage")
	public ModelAndView displayArrosage() {
		return redirect("Arrosage");
	}

	@GetMapping(value = "/formation")
	public ModelAndView displayFormation() {
		return redirect("Formation");
	}

	@GetMapping(value = "/compte")
	public ModelAndView displayCompte() {
		return redirect("Compte");
	}

	@GetMapping(value = "/infos")
	public ModelAndView displayInfos() {
		return redirect("Infos");
	}

}