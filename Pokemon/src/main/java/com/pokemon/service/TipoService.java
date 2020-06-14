package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.TipoEntity;
import com.pokemon.model.TipoModel;

public interface TipoService {
	
	public abstract List<TipoModel> listTipo();
    public abstract TipoModel addTipo(TipoModel tipoModel);
    public abstract int removeTipo(int id);
    public abstract TipoModel updateTipo(int id);

    public abstract TipoEntity transform(TipoModel tipoModel);
    public abstract TipoModel transform(TipoEntity tipo);
}
