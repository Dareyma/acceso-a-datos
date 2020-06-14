package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.PokemonEntity;

@Repository("pokemonRepository")
public interface PokemonJpaRepository extends JpaRepository<PokemonEntity, Serializable>{
	
	public abstract PokemonEntity findById(int id);
}
