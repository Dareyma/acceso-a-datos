package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.EquipoEntity;

@Repository("equipoRepository")
public interface EquipoJpaRepository extends JpaRepository<EquipoEntity, Serializable>{
	
	public abstract EquipoEntity findById(int id);
}
