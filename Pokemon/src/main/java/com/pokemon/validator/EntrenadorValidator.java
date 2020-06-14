package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.model.EntrenadorModel;

@Component
public class EntrenadorValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return EntrenadorModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		EntrenadorModel entrenador=(EntrenadorModel)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "El campo nombre es obligatorio");
		
		if(entrenador.getNombre().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre del pokemon debe tener un tamaño menor que 50 caracteres");
		}	
		if(entrenador.getEmail().length()<=11) {
			errors.rejectValue("email", "email.incorrect", "El email debe tener al menos 11 carácteres");
		}
	}
}
