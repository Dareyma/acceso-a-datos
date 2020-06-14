package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.PokemonEntity;
import com.pokemon.model.PokemonModel;

@Component("pokemonConverter")
public class PokemonConverter {

	//Entity --> Model
    public PokemonModel entity2model(PokemonEntity pokemon) {
    	PokemonModel pokemonModel=new PokemonModel();
    	pokemonModel.setId(pokemon.getId());
    	pokemonModel.setNombre(pokemon.getNombre());
    	pokemonModel.setAtaque(pokemon.getAtaque());
    	pokemonModel.setDefensa(pokemon.getDefensa());
        return pokemonModel;
    }
    
    public PokemonEntity model2entity(PokemonModel pokemonModel) {
    	PokemonEntity pokemon=new PokemonEntity();
    	pokemon.setId(pokemonModel.getId());
    	pokemon.setNombre(pokemonModel.getNombre());
    	pokemon.setAtaque(pokemonModel.getAtaque());
    	pokemon.setDefensa(pokemonModel.getDefensa());
        return pokemon;
    }

}
