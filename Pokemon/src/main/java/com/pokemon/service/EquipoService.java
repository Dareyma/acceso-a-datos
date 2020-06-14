package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.EquipoEntity;
import com.pokemon.model.EquipoModel;

public interface EquipoService {
	
	public abstract List<EquipoModel> listEquipo();
    public abstract EquipoModel addEquipo(EquipoModel equipoModel);
    public abstract int removeEquipo(int id);
    public abstract EquipoModel updateEquipo(int id);

    public abstract EquipoEntity transform(EquipoModel equipoModel);
    public abstract EquipoModel transform(EquipoEntity equipo);
}
