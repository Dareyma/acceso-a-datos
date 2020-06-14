package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.model.TipoModel;

@Component
public class tipoValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return TipoModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		TipoModel tipo=(TipoModel)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "El campo nombre es obligatorio");
		
		if(tipo.getNombre().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre del pokemon debe tener un tamaño menor que 50 caracteres");
		}	
		
	}
}
