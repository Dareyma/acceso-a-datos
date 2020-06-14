package com.pokemon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="clasificacion")

public class ClasificacionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
	@NotNull
    @Column(name="puntos")
    private int puntos;
    
	@NotNull
    @Column(name="puesto")
    private int puesto;
    
    @ManyToOne
    @JoinColumn(name="competicion")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private CompeticionEntity competicion;
    
    @ManyToOne
    @JoinColumn(name="equipo")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private EquipoEntity equipo;

	public ClasificacionEntity(int id, int puntos, int puesto, CompeticionEntity competicion, EquipoEntity equipo) {
		super();
		this.id = id;
		this.puntos = puntos;
		this.puesto = puesto;
		this.competicion = competicion;
		this.equipo = equipo;
	}

	public ClasificacionEntity() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public CompeticionEntity getCompeticion() {
		return competicion;
	}

	public void setCompeticion(CompeticionEntity competicion) {
		this.competicion = competicion;
	}

	public EquipoEntity getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoEntity equipo) {
		this.equipo = equipo;
	}

}
