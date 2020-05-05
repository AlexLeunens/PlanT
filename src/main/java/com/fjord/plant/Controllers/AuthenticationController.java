package com.fjord.plant.Controllers;

import javax.validation.Valid;

import com.fjord.plant.Model.ConfirmationToken;
import com.fjord.plant.Model.User;
import com.fjord.plant.Services.ConfirmationTokenService;
import com.fjord.plant.Services.EmailSenderService;
import com.fjord.plant.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@Autowired
	private ConfirmationTokenService confirmationTokenService;

	@Autowired
	private EmailSenderService emailSenderService;

	// TODO: the view's name will most likely change

	@GetMapping(value = "/login")
	public ModelAndView login() {

		ModelAndView result = new ModelAndView();
		result.setViewName("loginView");

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

		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			result.setViewName("register");
		} else {

			userService.saveUser(user);

			System.out.println("\n\n TRIED TO SAVE USER \n\n");
			User createdUser = userService.findUserByEmail(user.getEmail());
			ConfirmationToken confirmationToken = new ConfirmationToken(createdUser);
			confirmationTokenService.save(confirmationToken);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom("fjord.planT@gmail.com");

			// For now we link it to the localhost, maybe we can do better
			mailMessage.setText("To confirm your account, please click here : "
					+ "http://localhost:8080/confirmAccount?token=" + confirmationToken.getConfirmationToken());

			emailSenderService.sendEmail(mailMessage);

			result.addObject("successMessage", "User has been registered successfully ! Check your emails");
			result.addObject("user", new User());
			result.setViewName("register");
		}

		return result;
	}

	@GetMapping(value = "/confirmAccount")
	@PostMapping(value = "/confirmAccount")
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {

		ConfirmationToken token = confirmationTokenService.findByConfirmationToken(confirmationToken);

		if (token != null) {
			User user = userService.findUserByEmail(token.getUser().getEmail());
			user.setisVerified(true);
			userService.updateUser(user);
			modelAndView.setViewName("accountVerified");
		} else {
			modelAndView.addObject("message", "The link is invalid or broken!");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}
}