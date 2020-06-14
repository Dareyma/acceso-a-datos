package com.pokemon.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pokemon.constantes.constantes;
import com.pokemon.converter.Testcrypt;
import com.pokemon.entity.UserEntity;
import com.pokemon.entity.User_RoleEntity;
import com.pokemon.service.impl.UserRolServiceImpl;
import com.pokemon.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/")
public class RegisterController {
	
	private static final Log LOG=LogFactory.getLog(RegisterController.class);
	
	@Autowired
    @Qualifier("userServiceImpl")
    private UserServiceImpl userServiceImpl;

    @Autowired
    @Qualifier("userRolServiceImpl")
    private UserRolServiceImpl userRolServiceImpl;

    private Testcrypt enc=new Testcrypt();

    @GetMapping("/registro")
    public ModelAndView registrar() {
        ModelAndView mav =new ModelAndView(constantes.REGISTER_VIEW);
        mav.addObject("user",new UserEntity());
        return mav;
    }
    
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}
    
    @PostMapping("/addUser")
    public ModelAndView addUser(@ModelAttribute("user") UserEntity user,@RequestParam(name="rol")  String rol, User_RoleEntity user_Role, Model model, RedirectAttributes flash) {
        ModelAndView mav = new ModelAndView();
        user.setPassword(enc.encrypt(user.getPassword()));
        userServiceImpl.addUser(user);
        user_Role.setRole(rol);
        user_Role.setUser(user);
        LOG.info(user_Role.toString());
        userRolServiceImpl.addUser(user_Role);
        mav.setViewName("redirect:/"); 
        return mav;
    }
}
