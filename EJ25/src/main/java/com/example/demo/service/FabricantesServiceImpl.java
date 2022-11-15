package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFabricantesDAO;
import com.example.demo.dto.Fabricantes;

@Service
public class FabricantesServiceImpl implements IFabricantesService {

	@Autowired
	IFabricantesDAO iFabricanteDAO;

	@Override
	public List<Fabricantes> listarFabricantes() {
		return iFabricanteDAO.findAll();
	}

	@Override
	public Fabricantes crearFabricante(Fabricantes fabricante) {
		return iFabricanteDAO.save(fabricante);
	}

	@Override
	public Fabricantes leerFabricante(Long id) {
		return iFabricanteDAO.findById(id).get();
	}

	@Override
	public Fabricantes actualizarFabricante(Fabricantes fabricante) {
		return iFabricanteDAO.save(fabricante);
	}

	@Override
	public void borrarFabricante(Long id) {
		iFabricanteDAO.deleteById(id);
	}

}