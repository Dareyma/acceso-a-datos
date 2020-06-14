package com.pokemon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="competicion")



public class CompeticionEntity {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="competicion")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="fecha")
    private String fecha;
    
    @Column(name="lugar")
    private String lugar;

	public CompeticionEntity(int id, String nombre, String fecha, String lugar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
	}

	public CompeticionEntity() {
		
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
    
}
