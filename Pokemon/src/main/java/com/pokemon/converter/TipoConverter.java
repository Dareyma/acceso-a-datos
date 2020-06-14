package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.TipoEntity;
import com.pokemon.model.TipoModel;

@Component("tipoConverter")
public class TipoConverter {

	//Entity --> Model
    public TipoModel entity2model(TipoEntity tipo) {
    	TipoModel tipoModel=new TipoModel();
    	tipoModel.setId(tipo.getId());
    	tipoModel.setNombre(tipo.getNombre());
        return tipoModel;
    }
    
    public TipoEntity model2entity(TipoModel tipoModel) {
    	TipoEntity tipo=new TipoEntity();
    	tipo.setId(tipoModel.getId());
    	tipo.setNombre(tipoModel.getNombre());
        return tipo;
    }

}
