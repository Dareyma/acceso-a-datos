package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.User_RoleEntity;

public interface UserRolService {
	
	public abstract List<User_RoleEntity> getListUsuarios();
	public abstract User_RoleEntity addUser(User_RoleEntity usuarioRol);
	

}
