package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articulos") // Nombre de la tabla

public class Articulos {

	// Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int precio;
	

	@ManyToOne
	@JoinColumn(name = "fabricante_id")
	private Fabricantes fabricantes;
 
	// Constructores

	public Articulos() {
	}

	public Articulos(Long id, String nombre, int precio, Fabricantes fabricante_id) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fabricantes = fabricante_id;
	}

	// Setters y getters

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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Fabricantes getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(Fabricantes fabricante_id) {
		this.fabricantes = fabricante_id;
	}

	// To string personalizado
	@Override
	public String toString() {
		return "Empleado [id = " + id + ", nombre = " + nombre + ", precio " + precio + ", fabricante id " + fabricantes
				+ " ] ";
	}
}