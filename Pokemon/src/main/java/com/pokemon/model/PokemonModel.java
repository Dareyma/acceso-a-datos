package com.pokemon.model;

import com.pokemon.entity.TipoEntity;

public class PokemonModel {

	private int id;
	private String foto;
	private String nombre;
	private int ataque;
	private int defensa;
	private TipoEntity tipo;
	public PokemonModel(int id, String foto, String nombre, int ataque, int defensa, TipoEntity tipo) {
		super();
		this.id = id;
		this.foto = foto;
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.tipo = tipo;
	}
	public PokemonModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public TipoEntity getTipo() {
		return tipo;
	}
	public void setTipo(TipoEntity tipo) {
		this.tipo = tipo;
	}

	
	
	
}
