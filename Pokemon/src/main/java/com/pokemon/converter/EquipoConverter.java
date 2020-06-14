package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.EquipoEntity;
import com.pokemon.model.EquipoModel;

@Component("equipoConverter")
public class EquipoConverter {

	//Entity --> Model
    public EquipoModel entity2model(EquipoEntity equipo) {
    	EquipoModel equipoModel=new EquipoModel();
    	equipoModel.setId(equipo.getId());
        equipoModel.setNombre(equipo.getNombre());
        equipoModel.setDescripcion(equipo.getDescripcion());
        return equipoModel;
    }
    
    public EquipoEntity model2entity(EquipoModel equipoModel) {
    	EquipoEntity equipo=new EquipoEntity();
    	equipo.setId(equipoModel.getId());
    	equipo.setNombre(equipoModel.getNombre());
    	equipo.setDescripcion(equipoModel.getDescripcion());
        return equipo;
    }

}
