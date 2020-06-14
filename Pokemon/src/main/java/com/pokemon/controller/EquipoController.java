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

import com.pokemon.entity.CompeticionEntity;
import com.pokemon.entity.EquipoEntity;
import com.pokemon.model.EquipoModel;
import com.pokemon.repository.EquipoJpaRepository;
import com.pokemon.service.EquipoService;

@Controller
@RequestMapping("/equipo")

public class EquipoController {

	private static final String EQUIPO_VIEW="equipo";
    private static final String CREATE_VIEW="create";
    
    @Autowired
    @Qualifier("equipoServiceImpl")
    private EquipoService equipoService;
    
    
    @Autowired
    @Qualifier("equipoRepository")
    private EquipoJpaRepository equipoJpaRepository;
    
    @GetMapping("/listEquipo")
    public ModelAndView listEquipo() {
        ModelAndView mav = new ModelAndView(EQUIPO_VIEW);
        mav.addObject("equipo",new CompeticionEntity());
        mav.addObject("equipos", equipoService.listEquipo());
        return mav;
    }
    
    @PostMapping("/addCompeticion")
    public String addEquipo(@ModelAttribute("equipo") EquipoModel equipoModel) {
    	equipoService.addEquipo(equipoModel);
        return "redirect:/equipo/listEquipo";
        
    }
    
    
    @GetMapping("/create")
    public ModelAndView createEquipo(){
        ModelAndView mav=new ModelAndView(CREATE_VIEW);
        mav.addObject("equipo",new EquipoEntity());
        return mav;
    }
    
    
    @PostMapping("/delete")
    public String deleteEquipo(@RequestParam("id") int id) {
    	equipoService.removeEquipo(id);
        return "redirect:/equipo/listEquipo";
    }
}
