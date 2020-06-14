package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pokemon.entity.UserEntity;
import com.pokemon.entity.User_RoleEntity;
import com.pokemon.repository.UserJpaRepository;


@Service
public class UserServiceImpl implements UserDetailsService{
    
    private User buildUser(com.pokemon.entity.UserEntity user,
        List<GrantedAuthority> authorities) {
    return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }
    
    private List<GrantedAuthority> buildAuthorities(Set<User_RoleEntity> userRoles){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        
        for(User_RoleEntity user_Role: userRoles) {
            auths.add(new SimpleGrantedAuthority(user_Role.getRole()));
        }
        
        return new ArrayList<GrantedAuthority>(auths);
    }

    @Autowired
    @Qualifier("userJpaRepository")
    private UserJpaRepository userRepository;
    
    

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        com.pokemon.entity.UserEntity user = userRepository.findByUsername(name);
        List<GrantedAuthority> authorities = buildAuthorities(user.getUser_Role());    
        return buildUser(user, authorities);
    }
    
    
    
    public UserEntity addUser(UserEntity user) {
        user.setEnabled(true);
        return userRepository.save(user);
    }
}
