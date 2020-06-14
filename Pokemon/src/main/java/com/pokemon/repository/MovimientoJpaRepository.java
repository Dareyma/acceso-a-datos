package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.MovimientoEntity;

@Repository("movimientoRepository")
public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, Serializable>{
	
	public abstract MovimientoEntity findById(int id);
}
