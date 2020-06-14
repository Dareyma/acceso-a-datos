package com.pokemon.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class UserEntity {
	@Id
    @Column(name="username", unique=true, nullable=false, length=45)
    private String username;
    
    @Column(name="password", nullable=false, length=60)
    private String password;
    
    @Column(name="enabled")
    private boolean enabled;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="user")
    private Set<User_RoleEntity> userRole = new HashSet<User_RoleEntity>();

   

	public UserEntity(String username, String password, boolean enabled, Set<User_RoleEntity> user_Role
			) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = user_Role;
		
	}

	public UserEntity() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<User_RoleEntity> getUser_Role() {
		return userRole;
	}

	public void setUser_Role(Set<User_RoleEntity> user_Role) {
		this.userRole = user_Role;
	}

	
    
}
