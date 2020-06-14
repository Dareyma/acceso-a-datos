package com.pokemon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="equipo")
public class EquipoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="equipo")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @ManyToOne
	@JoinColumn(name="id_pkmn")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private PokemonEntity pokemon;

	public EquipoEntity(int id, String nombre, String descripcion, PokemonEntity pokemon) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pokemon = pokemon;
	}

	public EquipoEntity() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PokemonEntity getPokemon() {
		return pokemon;
	}

	public void setPokemon(PokemonEntity pokemon) {
		this.pokemon = pokemon;
	}

}