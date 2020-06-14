package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.ClasificacionEntity;
import com.pokemon.model.ClasificacionModel;

@Component("clasificacionConverter")
public class ClasificacionConverter {

	//Entity --> Model
    public ClasificacionModel entity2model(ClasificacionEntity clasificacion) {
    	ClasificacionModel clasificacionModel=new ClasificacionModel();
    	clasificacionModel.setId(clasificacion.getId());
    	clasificacionModel.setPuntos(clasificacion.getPuntos());
    	clasificacionModel.setPuesto(clasificacion.getPuesto());
        return clasificacionModel;
    }
    
    public ClasificacionEntity model2entity(ClasificacionModel clasificacionModel) {
    	ClasificacionEntity clasificacion=new ClasificacionEntity();
    	clasificacion.setId(clasificacionModel.getId());
    	clasificacion.setPuntos(clasificacionModel.getPuntos());
    	clasificacion.setPuesto(clasificacionModel.getPuesto());
        return clasificacion;
    }
}
