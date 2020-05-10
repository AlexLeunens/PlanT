package com.fjord.plant.Controllers;

import javax.validation.Valid;

import com.fjord.plant.Model.User;
import com.fjord.plant.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompteController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/compte")
    public ModelAndView updateUserInfos(@Valid User user, BindingResult bindingResult) {

        ModelAndView result = new ModelAndView();
        result.setViewName("redirect:/compte");
        User existing = userService.getCurrentUser();

        System.out.println("\n\n TRIED TO UPDATE USER " + user.getEmail() + " \n\n");

        if (existing == null || user == null) {
            bindingResult.rejectValue("email", "error.user", "There was an error getting the user");
        }
        if (!bindingResult.hasErrors()) {
            
            existing.setName(user.getName());
            existing.setSurname(user.getSurname());

            userService.updateUser(existing);

            result.addObject("user", user);
        }

        return result;
    }

}