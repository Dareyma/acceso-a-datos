package com.pokemon.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tipo")

public class TipoEntity {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
	@NotEmpty(message="El nombre del producto es obligatorio")
    @Column(name="nombre")
    private String nombre;
    
    //ManyToMany Pokemon-Tipos
/*    
    @ManyToMany(mappedBy = "tipo")
    private List<PokemonEntity> pokemon;
*/
	public TipoEntity(int id, @NotEmpty(message = "El nombre del producto es obligatorio") String nombre,
			List<PokemonEntity> pokemon) {
		super();
		this.id = id;
		this.nombre = nombre;
//		this.pokemon = pokemon;
	}
	
	public TipoEntity() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*
	public List<PokemonEntity> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<PokemonEntity> pokemon) {
		this.pokemon = pokemon;
	}
    
  //ManyToMany Pokemon-Tipos
*/
	


}
