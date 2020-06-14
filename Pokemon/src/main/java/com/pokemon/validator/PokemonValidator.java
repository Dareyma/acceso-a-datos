package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.model.PokemonModel;



@Component
public class PokemonValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PokemonModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		PokemonModel pokemon=(PokemonModel)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","El campo nombre del ciclista es obligatorio");
		
		if(pokemon.getNombre().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre del pokemon debe tener un tamaño menor que 50 caracteres");
		}
		
		if(pokemon.getAtaque()<=10) {
			errors.rejectValue("ataque", "ataque.incorrect", "El ataque debe ser un número superior a 10");
		}
		
		if(pokemon.getDefensa()<20) {
			errors.rejectValue("defensa", "defensa.incorrect", "La defensa deber ser mayor a 20");
		}
		
		
	}


}
