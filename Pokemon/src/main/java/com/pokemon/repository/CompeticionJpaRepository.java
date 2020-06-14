package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.CompeticionEntity;

@Repository("competicionRepository")
public interface CompeticionJpaRepository extends JpaRepository<CompeticionEntity, Serializable>{
	
	public abstract CompeticionEntity findById(int id);
}
