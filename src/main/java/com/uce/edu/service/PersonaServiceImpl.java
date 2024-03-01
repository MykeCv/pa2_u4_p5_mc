package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IPersonaRepository;
import com.uce.edu.repository.modelo.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepository iPersonaRepository;

	@Override
	public void guardar(Persona persona) {
		this.iPersonaRepository.insertar(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		return this.iPersonaRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void actualizar(Persona persona) {
		this.iPersonaRepository.actualizar(persona);
	}

	@Override
	public void borrar(String cedula) {
		this.iPersonaRepository.eliminar(cedula);
	}

	@Override
	public List<Persona> buscarTodo() {
		return this.iPersonaRepository.selecTodo();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		return this.iPersonaRepository.select(id);
	}
}
