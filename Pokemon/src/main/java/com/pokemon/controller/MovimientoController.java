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
import com.pokemon.entity.MovimientoEntity;
import com.pokemon.model.MovimientoModel;
import com.pokemon.repository.MovimientoJpaRepository;
import com.pokemon.service.MovimientoService;

@Controller
@RequestMapping("/movimiento")	
public class MovimientoController {
    
    @Autowired
    @Qualifier("movimientoServiceImpl")
    private MovimientoService movimientoService;
    
    
    @Autowired
    @Qualifier("movimientoRepository")
    private MovimientoJpaRepository movimientoJpaRepository;
    
    @GetMapping("/listMovimiento")
    public ModelAndView listCompeticion() {
        ModelAndView mav = new ModelAndView(constantes.MOVIMIENTO_VIEW);
        mav.addObject("movimiento",new MovimientoEntity());
        mav.addObject("movimientos", movimientoService.listMovimiento());
        return mav;
    }
    
    @PostMapping("/addMovimiento")
    public String addMovimiento(@ModelAttribute("movimiento") MovimientoModel movimientoModel) {
    	movimientoService.addMovimiento(movimientoModel);
        return "redirect:/movimiento/listMovimiento";
        
    }
    
    
    @GetMapping("/create")
    public ModelAndView createMovimiento(){
        ModelAndView mav=new ModelAndView(constantes.CREATEMOVIMIENTO_VIEW);
        mav.addObject("movimiento",new MovimientoEntity());
        return mav;
    }
    
    
    @PostMapping("/delete")
    public String deleteMovimiento(@RequestParam("id") int id) {
    	movimientoService.removeMovimiento(id);
        return "redirect:/movimiento/listMovimiento";
    }
    
    @GetMapping("/edit")
    public ModelAndView editMovimiento(@RequestParam(name="id", required=true) int id, MovimientoModel movimientoModel){
    	ModelAndView mav = new ModelAndView(constantes.EDITMOVIMIENTO_VIEW);
    	mav.addObject("movimiento", movimientoService.updateMovimiento(id));
    	
    	return mav;
    }
}
