package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.PokemonConverter;
import com.pokemon.entity.PokemonEntity;
import com.pokemon.model.PokemonModel;
import com.pokemon.repository.PokemonJpaRepository;
import com.pokemon.service.PokemonService;

@Service("pokemonServiceImpl")
public class PokemonServiceImpl implements PokemonService{

	 @Autowired
	    @Qualifier("pokemonRepository")
	    private PokemonJpaRepository pokemonJpaRepository;
	    
	 @Autowired
	    private DozerBeanMapper dozer;
	 
	 @Autowired
	 @Qualifier("pokemonConverter")
	 private PokemonConverter pokemonConverter;
	    
	 @Override
	    public List<PokemonModel> listPokemon() {
	        List<PokemonEntity> listaPokemon=pokemonJpaRepository.findAll();
	        List<PokemonModel> listaCModel=new ArrayList<>();
	        listaPokemon.forEach(a->{
	        	PokemonModel pokemonModel=transform(a);
	            listaCModel.add(pokemonModel);
	        });
	        
	        Collections.sort(listaCModel, (PokemonModel c1, PokemonModel c2) -> c1.getNombre().compareTo(c2.getNombre()));
	        
	        return listaCModel;
	    }

	    @Override
	    public PokemonModel addPokemon(PokemonModel pokemonModel) {
	    	PokemonEntity pokemon=transform(pokemonModel);
	        return transform(pokemonJpaRepository.save(pokemon));
	    }
	 
	    @Override
	    public PokemonModel updatePokemon(int id){
	    	PokemonModel pokemonModel = new PokemonModel();
	    	PokemonEntity pokemon = pokemonJpaRepository.findById(id);
	    	pokemonJpaRepository.deleteById(id);
	    	pokemonModel = pokemonConverter.entity2model(pokemon);
	        return pokemonModel;
	    } 

	    @Override
	    public int removePokemon(int id) {
	    	pokemonJpaRepository.deleteById(id);
	        return 0;
	    }
	    
	    
	    @Override
	    public PokemonEntity transform(PokemonModel pokemonModel) {
	        return dozer.map(pokemonModel, PokemonEntity.class);
	    }
	    
	    @Override
	    public PokemonModel transform(PokemonEntity pokemon) {
	        return dozer.map(pokemon, PokemonModel.class);
	    }
}
