package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")

public class ProfileController {
	
	private static final String PROFILE_VIEW="profile";
	
	@GetMapping("/profile")
	public ModelAndView crud() {
		ModelAndView mav=new ModelAndView(PROFILE_VIEW);
		
		return mav;
	}
}
