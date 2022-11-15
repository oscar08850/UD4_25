package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Articulos;

public interface IArticulosService {

	// Metodos del CRUD

	public List<Articulos> listarArticulos(); // Listar All

	public Articulos crearArticulo(Articulos articulos); // CREATE

	public Articulos leerArticulo(Long id); // READ

	public Articulos actualizarArticulo(Articulos articulo); // UPDATE

	public void borrarArticulo(Long id); // DELETE

}