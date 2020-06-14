package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.User_RoleEntity;

@Repository("userRoleJpaRepository")
public interface User_RoleJpaRepository extends JpaRepository <User_RoleEntity, Serializable>{
	

}
