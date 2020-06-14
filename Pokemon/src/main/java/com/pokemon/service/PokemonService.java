package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.PokemonEntity;
import com.pokemon.model.PokemonModel;

public interface PokemonService {
	
	public abstract List<PokemonModel> listPokemon();
    public abstract PokemonModel addPokemon(PokemonModel pokemonModel);
    public abstract int removePokemon(int id);
    public abstract PokemonModel updatePokemon(int id);

    public abstract PokemonEntity transform(PokemonModel pokemonModel);
    public abstract PokemonModel transform(PokemonEntity pokemon);
}
