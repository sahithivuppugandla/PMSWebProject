package com.wellsfargo.batch5.pms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.RegisterBackOfficeUserModel;
import com.wellsfargo.batch5.pms.model.RegisterInvestorModel;
import com.wellsfargo.batch5.pms.security.UserDetailsServiceImpl;


@Controller
public class SecurityController {

	@Autowired
	private UserDetailsServiceImpl userService;
	
	@GetMapping("/login")
	public String gotoLogin() {
		String view="login-page";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view="redirect:/home";
		}

		return view; 
	}
	
	@GetMapping("/register/bor")
	public ModelAndView showRegisterationForm() {
		return  new ModelAndView("registerbor-form-page","user",new RegisterBackOfficeUserModel());
	}
	
	@PostMapping("/register/bor")
	public ModelAndView doRegisteration(
			@ModelAttribute("user") @Valid RegisterBackOfficeUserModel user,
			BindingResult result) throws PortfolioException {
		ModelAndView mv = null;
		if(result.hasErrors()) {
			mv = new ModelAndView("registerbor-form-page","user",user);
		}else {
			userService.registerBORMember(user);
			mv=new ModelAndView("redirect:/home");
		}
		return  mv;
	}
	
	@GetMapping("/register")
	public ModelAndView showRegistrationForm() {
		return  new ModelAndView("register-form-page","user",new RegisterInvestorModel());
	}
	
	@PostMapping("/register")
	public ModelAndView doRegistration(
			@ModelAttribute("user") @Valid RegisterInvestorModel user,
			BindingResult result) throws PortfolioException {
		ModelAndView mv = null;
		if(result.hasErrors()) {
			mv = new ModelAndView("register-form-page","user",user);
		}else {
			userService.registerInvestor(user);
			mv=new ModelAndView("redirect:/home");
		}
		return  mv;
	}
}
