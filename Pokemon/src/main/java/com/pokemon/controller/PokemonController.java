package com.pokemon.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pokemon.components.PDF;
import com.pokemon.constantes.constantes;
import com.pokemon.entity.PokemonEntity;
import com.pokemon.entity.TipoEntity;
import com.pokemon.model.PokemonModel;
import com.pokemon.repository.PokemonJpaRepository;
import com.pokemon.service.PokemonService;
import com.pokemon.service.TipoService;
import com.pokemon.validator.PokemonValidator;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {
    
    private PDF pdfPokemon = new PDF();
    
    @Autowired
    @Qualifier("pokemonServiceImpl")
    private PokemonService pokemonService;
    
    @Autowired
    @Qualifier("tipoServiceImpl")
    private TipoService tipoService;
    
    private PokemonValidator validator=new PokemonValidator();
    
    @Autowired
    @Qualifier("pokemonRepository")
    private PokemonJpaRepository pokemonJpaRepository;
    
    
    private static final Log LOG=LogFactory.getLog(PokemonController.class);
    
    @GetMapping("/listPokemon")
    public ModelAndView listPokemon() {
        ModelAndView mav = new ModelAndView(constantes.POKEMON_VIEW);
        mav.addObject("pokemon",new PokemonEntity());
        mav.addObject("pokemones", pokemonService.listPokemon());
        return mav;
    }
    
    @PostMapping("/addPokemon")
	public String addPokemon(@ModelAttribute("file") MultipartFile img, @Valid @ModelAttribute("pokemon") PokemonModel pokemonModel, BindingResult result,
			RedirectAttributes flash, Model model) {
			
    	 	this.validator.validate(pokemonModel, result);
			if (result.hasErrors()) {
				LOG.info("error");
				model.addAttribute("pokemon", pokemonService.listPokemon());
				LOG.info("error"+result.getFieldError());
				return "redirect:/pokemon/listPokemon";
			}else {
				if(!img.isEmpty()) {
					Path directory=Paths.get(".\\src\\main\\resources\\static\\images");
					String ruta=directory.toFile().getAbsolutePath();
					try {
						byte[] bytes=img.getBytes();
						Path rutaCompleta=Paths.get(ruta+"\\"+pokemonModel.getId()+pokemonModel.getNombre()+".png");
						Files.write(rutaCompleta,bytes);
						pokemonModel.setFoto("/images/"+pokemonModel.getId() + pokemonModel.getNombre()+".png");
					}catch(IOException e) {
						e.printStackTrace();
					}
				}else {
					
					pokemonModel.setFoto("/images/0infernape.png");
				}
				pokemonService.addPokemon(pokemonModel);
			}
			return "redirect:/pokemon/listPokemon";
		} 
    
    @GetMapping("/create")
    public ModelAndView createPokemon(){
        ModelAndView mav=new ModelAndView(constantes.CREATEPOKEMON_VIEW);
        mav.addObject("pokemon",new PokemonEntity());
        mav.addObject("tipos",tipoService.listTipo());
        return mav;
    }
    
    
    @PostMapping("/delete")
    public String deletePokemon(@RequestParam("id") int id) {
    	pokemonService.removePokemon(id);
        return "redirect:/pokemon/listPokemon";
    }
    
    @GetMapping("/edit")
    public ModelAndView editTipo(@RequestParam(name="id", required=true) int id, PokemonModel pokemonModel){
    	ModelAndView mav = new ModelAndView(constantes.EDITPOKEMON_VIEW);
    	mav.addObject("pokemon", pokemonService.updatePokemon(id));
    	
    	return mav;
    }
    
    @GetMapping("/generarPDF")
    public String generarPDF(RedirectAttributes flash) {
        List<PokemonModel> list=pokemonService.listPokemon();
        pdfPokemon.PDFPokemon(list);
        flash.addFlashAttribute("success","PDF generado correctamente");
        return "redirect:/pokemon/listPokemon";
        
    }
    
    
}
