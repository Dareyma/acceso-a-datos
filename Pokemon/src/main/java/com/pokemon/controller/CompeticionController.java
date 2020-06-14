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

import com.pokemon.constantes.constantes;
import com.pokemon.entity.CompeticionEntity;
import com.pokemon.model.CompeticionModel;
import com.pokemon.repository.CompeticionJpaRepository;
import com.pokemon.service.CompeticionService;

@Controller
@RequestMapping("/competicion")

public class CompeticionController {
    
    @Autowired
    @Qualifier("competicionServiceImpl")
    private CompeticionService competicionService;
    
    
    @Autowired
    @Qualifier("competicionRepository")
    private CompeticionJpaRepository competicionJpaRepository;
    
    @GetMapping("/listCompeticion")
    public ModelAndView listCompeticion() {
        ModelAndView mav = new ModelAndView(constantes.COMPETICION_VIEW);
        mav.addObject("competicion",new CompeticionEntity());
        mav.addObject("competiciones", competicionService.listCompeticion());
        return mav;
    }
    
    @PostMapping("/addCompeticion")
    public String addCompeticion(@ModelAttribute("competicion") CompeticionModel competicionModel) {
        competicionService.addCompeticion(competicionModel);
        return "redirect:/competicion/listCompeticion";
        
    }
    
    
    @GetMapping("/create")
    public ModelAndView createCompeticion(){
        ModelAndView mav=new ModelAndView(constantes.CREATECOMPETICION_VIEW);
        mav.addObject("competicion",new CompeticionEntity());
        return mav;
    }
    
    
    @PostMapping("/delete")
    public String deleteCompeticion(@RequestParam("id") int id) {
        competicionService.removeCompeticion(id);
        return "redirect:/competicion/listCompeticion";
    }
    
    
    @GetMapping("/edit")
    public ModelAndView editCompeticion(@RequestParam(name="id", required=true) int id, CompeticionModel competicionModel){
    	ModelAndView mav = new ModelAndView(constantes.EDITCOMPETICION_VIEW);
    	mav.addObject("competicion", competicionService.updateCompeticion(id));
    	
    	return mav;
    }
    
}
