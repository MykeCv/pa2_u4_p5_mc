package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Persona;

public interface IPersonaService {

	public void guardar(Persona persona);

	public Persona buscarPorCedula(String cedula);

	public void actualizar(Persona persona);

	public void borrar(String cedula);

	public List<Persona> buscarTodo();

	public Persona buscarPorId(Integer id);
}
