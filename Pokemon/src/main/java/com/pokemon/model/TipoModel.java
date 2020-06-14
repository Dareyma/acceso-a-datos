package com.pokemon.model;

public class TipoModel {

	private int id;
	private String nombre;

	public TipoModel(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		
	}
	public TipoModel() {
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
	
	
}
