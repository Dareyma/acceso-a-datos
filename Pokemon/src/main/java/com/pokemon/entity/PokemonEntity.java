package com.pokemon.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="pokemon")

public class PokemonEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_pkmn")
    private int id;
    
	@NotEmpty(message="El nombre es obligatorio")
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="foto")
    private String foto;
    
    @NotNull
    @Column(name="ataque")
    private int ataque;
    
    @Min(20)
    @NotNull
    @Column(name="defensa")
    private int defensa;

  //ManyToMany Pokemon-tipo
    
 /*   @JoinTable(
            name = "rel_tipos_pokemon",
            joinColumns = @JoinColumn(name = "FK_TIPOS", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_POKEMON", nullable = false)
    )
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<TipoEntity> tipo;
    
  //ManyToMany Pokemon-movimiento
 */
    
    @JoinTable(
            name = "rel_movimientos_pokemon",
            joinColumns = @JoinColumn(name = "FK_MOVIMIENTO", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_POKEMON", nullable = false)
    )
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<MovimientoEntity> movimiento;

public PokemonEntity(int id, @NotEmpty(message = "El nombre es obligatorio") String nombre, String foto,
		@Size(min = 10, max = 40) @NotNull int ataque, @Min(20) @NotNull int defensa, List<TipoEntity> tipo,
		
	List<MovimientoEntity> movimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.ataque = ataque;
		this.defensa = defensa;
//		this.tipo = tipo;
		this.movimiento = movimiento;
	}

	public PokemonEntity() {
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
	/*
	public List<TipoEntity> getTipo() {
		return tipo;
	}
	
	public void setTipo(List<TipoEntity> tipo) {
		this.tipo = tipo;
	}
	*/
	public List<MovimientoEntity> getMovimiento() {
		return movimiento;
	}
	
	public void setMovimiento(List<MovimientoEntity> movimiento) {
		this.movimiento = movimiento;
	}
    
	
}
