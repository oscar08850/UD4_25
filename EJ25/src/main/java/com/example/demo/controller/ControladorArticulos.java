package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Articulos;
import com.example.demo.service.ArticulosServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorArticulos {

	@Autowired
	ArticulosServiceImpl articulosServiceImpl;

	@GetMapping("/articulos")
	public List<Articulos> listarArticulos() {
		return articulosServiceImpl.listarArticulos();
	}

	@PostMapping("/articulos")
	public Articulos crearArticulo(@RequestBody Articulos articulo) {

		return articulosServiceImpl.crearArticulo(articulo);

	}

	@GetMapping("/articulos/{id}")
	public Articulos leerArticulo(@PathVariable(name = "id") Long id) {

		Articulos articulo = new Articulos();

		articulo = articulosServiceImpl.leerArticulo(id);

		System.out.println("Articulo segun ID: " + articulo);

		return articulo;
	}

	@PutMapping("/articulos/{id}")
	public Articulos actualizarArticulo(@PathVariable(name = "id") Long id, @RequestBody Articulos articulo) {

		Articulos articulo_seleccionado = new Articulos();
		Articulos articulo_actualizado = new Articulos();

		articulo_seleccionado = articulosServiceImpl.leerArticulo(id);

		articulo_seleccionado.setNombre(articulo.getNombre());
		articulo_seleccionado.setPrecio(articulo.getPrecio());
		articulo_seleccionado.setFabricantes(articulo.getFabricantes());

		articulo_actualizado = articulosServiceImpl.actualizarArticulo(articulo_seleccionado);

		System.out.println("El articulo actualizado es: " + articulo_actualizado);

		return articulo_actualizado;
	}

	@DeleteMapping("/articulos/{id}")
	public void borrarArticulo(@PathVariable(name = "id") Long id) {
		articulosServiceImpl.borrarArticulo(id);
	}

}