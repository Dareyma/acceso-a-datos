package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.model.MovimientoModel;

@Component
public class movimientoValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MovimientoModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		MovimientoModel movimiento=(MovimientoModel)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "El campo nombre es obligatorio");
		
		if(movimiento.getNombre().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre del pokemon debe tener un tamaño menor que 50 caracteres");
		}	
		if(movimiento.getDescripcion().length()<=10) {
			errors.rejectValue("descripcion", "descripcion.incorrect", "La descripcion debe tener al menos 20 carácteres");
		}
		
		if(movimiento.getPotencia()<10) {
			errors.rejectValue("potencia", "potencia.incorrect", "La potenciadeber ser mayor a 10");
		}
		
		if(movimiento.getPrecission()<50) {
			errors.rejectValue("precission", "precission.incorrect", "La precision deber ser mayor a 50");
		}
		
		
	}

}
