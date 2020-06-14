package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.ClasificacionEntity;

@Repository("clasificacionRepository")
public interface ClasificacionJpaRepository extends JpaRepository<ClasificacionEntity, Serializable>{
	
	

}
