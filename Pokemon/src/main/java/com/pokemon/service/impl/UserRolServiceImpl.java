package com.pokemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.entity.User_RoleEntity;
import com.pokemon.repository.User_RoleJpaRepository;
import com.pokemon.service.UserRolService;

@Service
public class UserRolServiceImpl implements UserRolService {
	
	@Autowired
    @Qualifier("userRoleJpaRepository")
    private User_RoleJpaRepository userRoleRepository;
    

	@Override
	public List<com.pokemon.entity.User_RoleEntity> getListUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User_RoleEntity addUser(User_RoleEntity user) {
		return userRoleRepository.save(user);
	}
	

}
