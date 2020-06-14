package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.EntrenadorEntity;
import com.pokemon.model.EntrenadorModel;

public interface EntrenadorService {
	
	public abstract List<EntrenadorModel> listEntrenador();
    public abstract EntrenadorModel addEntrenador(EntrenadorModel entrenadorModel);
    public abstract int removeEntrenador(int id);
    public abstract EntrenadorModel updateEntrenador(int id);
    
    public abstract EntrenadorEntity transform(EntrenadorModel entrenadorModel);
    public abstract EntrenadorModel transform(EntrenadorEntity entrenador);

}
