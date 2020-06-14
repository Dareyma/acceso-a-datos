package com.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pokemon.entity.EntrenadorEntity;
import com.pokemon.model.EntrenadorModel;
import com.pokemon.repository.EntrenadorJpaRepository;
import com.pokemon.service.EntrenadorService;

@Controller
@RequestMapping("/entrenador")
public class EntrenadorController {
	private static final String ENTRENADOR_VIEW="entrenador";
    private static final String CREATE_VIEW="create";
    
    @Autowired
    @Qualifier("entrenadorServiceImpl")
    private EntrenadorService entrenadorService;
    
    
    @Autowired
    @Qualifier("entrenadorRepository")
    private EntrenadorJpaRepository entrenadorJpaRepository;
    
    @GetMapping("/listEntrenador")
    public ModelAndView listEntrenador() {
        ModelAndView mav = new ModelAndView(ENTRENADOR_VIEW);
        mav.addObject("entrenador",new EntrenadorEntity());
        mav.addObject("entrenadores", entrenadorService.listEntrenador());
        return mav;
    }
    
    @PostMapping("/addEntrenador")
    public String addEntrenador(@ModelAttribute("entrenador") EntrenadorModel entrenadorModel) {
    	entrenadorService.addEntrenador(entrenadorModel);
        return "redirect:/entrenador/listEntrenador";
        
    }
    
    
    @GetMapping("/create")
    public ModelAndView createEntrenador(){
        ModelAndView mav=new ModelAndView(CREATE_VIEW);
        mav.addObject("entrenador",new EntrenadorEntity());
        return mav;
    }
    
    
    @PostMapping("/delete")
    public String deleteEntrenador(@RequestParam("id") int id) {
    	entrenadorService.removeEntrenador(id);
        return "redirect:/entrenador/listEntrenador";
    }
}
