package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IArticulosDAO;
import com.example.demo.dto.Articulos;

@Service
public class ArticulosServiceImpl implements IArticulosService {

	@Autowired
	IArticulosDAO iArticuloDAO;

	@Override
	public List<Articulos> listarArticulos() {
		return iArticuloDAO.findAll();
	}

	@Override
	public Articulos crearArticulo(Articulos articulo) {
		return iArticuloDAO.save(articulo);
	}

	@Override
	public Articulos leerArticulo(Long id) {
		return iArticuloDAO.findById(id).get();
	}

	@Override
	public Articulos actualizarArticulo(Articulos articulo) {
		return iArticuloDAO.save(articulo);
	}

	@Override
	public void borrarArticulo(Long id) {
		iArticuloDAO.deleteById(id);
	}

}