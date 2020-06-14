package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.EntrenadorEntity;

@Repository("entrenadorRepository")
public interface EntrenadorJpaRepository extends JpaRepository<EntrenadorEntity, Serializable>{

	public abstract EntrenadorEntity findById(int id);
}
