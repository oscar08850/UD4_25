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

import com.example.demo.dto.Fabricantes;
import com.example.demo.service.FabricantesServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorFabricantes {


	@Autowired
	FabricantesServiceImpl fabricantesServiceImpl;
	
	@GetMapping("/fabricantes")
	public List<Fabricantes> listarFabricantes(){
		return fabricantesServiceImpl.listarFabricantes();
	}
	
	@PostMapping("/fabricantes")
	public Fabricantes crearFabricante(@RequestBody Fabricantes fabricante) {
		
		return fabricantesServiceImpl.crearFabricante(fabricante);
		
	}
	
	
	@GetMapping("/fabricantes/{id}")
	public Fabricantes leerFabricante(@PathVariable(name="id") Long id) {
		
		Fabricantes fabricante= new Fabricantes();
		
		fabricante=fabricantesServiceImpl.leerFabricante(id);
		
		System.out.println("Fabricante segun ID: "+fabricante);
		
		return fabricante;
	}
	
	@PutMapping("/fabricantes/{id}")
	public Fabricantes actualizarFabricante(@PathVariable(name="id")Long id,@RequestBody Fabricantes fabricante) {
		
		Fabricantes fabricante_seleccionado= new Fabricantes();
		Fabricantes fabricante_actualizado= new Fabricantes();
		
		fabricante_seleccionado= fabricantesServiceImpl.leerFabricante(id);

		fabricante_seleccionado.setNombre(fabricante.getNombre());
		
		fabricante_actualizado = fabricantesServiceImpl.actualizarFabricante(fabricante_seleccionado);
		
		System.out.println("El fabricante actualizado es: "+ fabricante_actualizado);
		
		return fabricante_actualizado;
	}
	
	@DeleteMapping("/fabricantes/{id}")
	public void borrarFabricante(@PathVariable(name="id")Long id) {
		fabricantesServiceImpl.borrarFabricante(id);
	}
	
}