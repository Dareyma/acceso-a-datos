package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.TipoEntity;

@Repository("tipoRepository")
public interface TipoJpaRepository extends JpaRepository<TipoEntity, Serializable>{
	
	public abstract TipoEntity findById(int id);
}
