	package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.MovimientoEntity;
import com.pokemon.model.MovimientoModel;

public interface MovimientoService {
	
	public abstract List<MovimientoModel> listMovimiento();
    public abstract MovimientoModel addMovimiento(MovimientoModel movimientoModel);
    public abstract int removeMovimiento(int id);
    public abstract MovimientoModel updateMovimiento(int id);

    public abstract MovimientoEntity transform(MovimientoModel movimientoModel);
    public abstract MovimientoModel transform(MovimientoEntity movimiento);
}
