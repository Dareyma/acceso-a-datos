package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.MovimientoEntity;
import com.pokemon.model.MovimientoModel;

@Component("movimientoConverter")
public class MovimientoConverter {

	//Entity --> Model
    public MovimientoModel entity2model(MovimientoEntity movimiento) {
    	MovimientoModel movimientoModel=new MovimientoModel();
    	movimientoModel.setId(movimiento.getId());
    	movimientoModel.setNombre(movimiento.getNombre());
    	movimientoModel.setDescripcion(movimiento.getDescripcion());
    	movimientoModel.setPotencia(movimiento.getPotencia());
    	movimientoModel.setPrecission(movimiento.getPrecission());
        return movimientoModel;
    }
    
    public MovimientoEntity model2entity(MovimientoModel movimientoModel) {
    	MovimientoEntity movimiento=new MovimientoEntity();
    	movimiento.setId(movimientoModel.getId());
    	movimiento.setNombre(movimientoModel.getNombre());
    	movimiento.setDescripcion(movimientoModel.getDescripcion());
    	movimiento.setPotencia(movimientoModel.getPotencia());
    	movimiento.setPrecission(movimientoModel.getPrecission());
        return movimiento;
    }

}
