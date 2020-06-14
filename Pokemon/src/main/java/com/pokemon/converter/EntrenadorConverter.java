package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.EntrenadorEntity;
import com.pokemon.model.EntrenadorModel;

@Component("entrenadorConverter")
public class EntrenadorConverter {

	//Entity --> Model
    public EntrenadorModel entity2model(EntrenadorEntity entrenador) {
    	EntrenadorModel entrenadorModel=new EntrenadorModel();
    	entrenadorModel.setId(entrenador.getId());
    	entrenadorModel.setNombre(entrenador.getNombre());
    	entrenadorModel.setFoto(entrenador.getFoto());
    	entrenadorModel.setEmail(entrenador.getEmail());
        return entrenadorModel;
    }
    
    public EntrenadorEntity model2entity(EntrenadorModel entrenadorModel) {
    	EntrenadorEntity entrenador=new EntrenadorEntity();
    	entrenador.setId(entrenadorModel.getId());
    	entrenador.setNombre(entrenadorModel.getNombre());
    	entrenador.setFoto(entrenadorModel.getFoto());
    	entrenador.setEmail(entrenadorModel.getEmail());
        return entrenador;
    }

}
