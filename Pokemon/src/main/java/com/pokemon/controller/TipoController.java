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
import com.pokemon.entity.TipoEntity;
import com.pokemon.model.TipoModel;
import com.pokemon.repository.TipoJpaRepository;
import com.pokemon.service.TipoService;

@Controller
@RequestMapping("/tipo")
public class TipoController {
    
    @Autowired
    @Qualifier("tipoServiceImpl")
    private TipoService tipoService;
    
    
    @Autowired
    @Qualifier("tipoRepository")
    private TipoJpaRepository tipoJpaRepository;
    
    @GetMapping("/listTipo")
    public ModelAndView listTipo() {
        ModelAndView mav = new ModelAndView(constantes.TIPO_VIEW);
        mav.addObject("tipo",new TipoEntity());
        mav.addObject("tipos", tipoService.listTipo());
        return mav;
    }
    
    @PostMapping("/addTipo")
    public String addTipo(@ModelAttribute("tipo") TipoModel tipoModel) {
    	tipoService.addTipo(tipoModel);
        return "redirect:/tipo/listTipo";
        
    }
    
    
    @GetMapping("/create")
    public ModelAndView createTipo(){
        ModelAndView mav=new ModelAndView(constantes.CREATETIPO_VIEW);
        mav.addObject("tipo",new TipoEntity());
        return mav;
    }
    
    
    @PostMapping("/delete")
    public String deleteTipo(@RequestParam("id") int id) {
    	tipoService.removeTipo(id);
        return "redirect:/tipo/listTipo";
    }
    
    @GetMapping("/edit")
    public ModelAndView editTipo(@RequestParam(name="id", required=true) int id, TipoModel tipoModel){
    	ModelAndView mav = new ModelAndView(constantes.EDITTIPO_VIEW);
    	mav.addObject("tipo", tipoService.updateTipo(id));
    	
    	return mav;
    }
}
