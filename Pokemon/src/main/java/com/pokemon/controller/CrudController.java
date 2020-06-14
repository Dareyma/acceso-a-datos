package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")

public class CrudController {
	
	private static final String CRUD_VIEW="crud";
	
	@GetMapping("/crud")
	public ModelAndView crud() {
		ModelAndView mav=new ModelAndView(CRUD_VIEW);
		
		return mav;
	}
}
