package com.pokemon.model;

public class MovimientoModel {

	private int id;
	private String nombre;
	private String descripcion;
	private int potencia;
	private int precission;
	
	public MovimientoModel() {
		
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
}
