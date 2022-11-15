package com.example.demo.dto;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="fabricantes")

public class Fabricantes {

	//Atributos de la entidad Fabricante
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="fabricante_id")
	private List<Articulos> articulos;
	
	//Constructores
	
	public Fabricantes() {
		
	}
	
	public Fabricantes(Long id, String nombre) {
		this.id=id;
		this.nombre=nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fabricante_id")
	public List<Articulos> getFabricantes_id() {
		return articulos;
	}

	public void setFabricantes_id(List<Articulos> articulo) {
		this.articulos = articulo;
	}

	//To string personalizado
	@Override
	public String toString() {
		return "Fabricante [id = " + id +", nombre = " + nombre +"] ";
	}
}