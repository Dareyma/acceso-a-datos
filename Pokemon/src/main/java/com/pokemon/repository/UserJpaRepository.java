package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.UserEntity;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository <UserEntity, Serializable>{
	public abstract UserEntity findByUsername(String username);
}
