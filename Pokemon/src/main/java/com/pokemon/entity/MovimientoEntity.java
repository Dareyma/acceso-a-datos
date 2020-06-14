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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="movimientos")

public class MovimientoEntity {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
	@NotEmpty(message="El nombre del producto es obligatorio")
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @NotNull(message="La potencia es obligatorio")
    @Column(name="potencia")
    private int potencia;
    
    @NotNull(message="La precision es obligatorio")
    @Column(name="precission")
    private int precission;
    
    //ManyToMany Pokemon-Movimientos
    
    @ManyToMany(mappedBy = "movimiento")
    private List<PokemonEntity> pokemon;

	public MovimientoEntity(int id, @NotEmpty(message = "El nombre del producto es obligatorio") String nombre,
			String descripcion, @NotNull(message = "La potencia es obligatorio") @Size(min = 10, max = 40) int potencia,
			@NotNull(message = "La precision es obligatorio") @Size(min = 50, max = 100) int precission,
			List<PokemonEntity> pokemon) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.potencia = potencia;
		this.precission = precission;
		this.pokemon = pokemon;
	}

	public MovimientoEntity() {
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

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getPrecission() {
		return precission;
	}

	public void setPrecission(int precission) {
		this.precission = precission;
	}

	public List<PokemonEntity> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<PokemonEntity> pokemon) {
		this.pokemon = pokemon;
	}

}
