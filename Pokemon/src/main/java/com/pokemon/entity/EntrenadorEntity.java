package com.pokemon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="entrenador")
public class EntrenadorEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="El nombre es obligatorio")
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="foto")
	private String foto;
	
	@NotEmpty(message="El email es obligatorio")
	@Column(name="email")
	private String email;
	
	@ManyToOne
    @JoinColumn(name="equipo")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private EquipoEntity equipo;

	public EntrenadorEntity(int id, @NotEmpty(message = "El nombre es obligatorio") String nombre, String foto,
			@NotEmpty(message = "El email es obligatorio") String email, EquipoEntity equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.email = email;
		this.equipo = equipo;
	}

	public EntrenadorEntity() {
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EquipoEntity getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoEntity equipo) {
		this.equipo = equipo;
	}


	
}
