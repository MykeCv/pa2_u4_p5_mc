package com.uce.edu.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.service.IPersonaService;

@Controller
@RequestMapping(value = "/personas")
public class PersonaControler {
	@Autowired
	private IPersonaService iPersonaService;

	// Cuendo viaja el modelo en el response
	// http://localhost:8080/personas/buscarPorCedula/?
	@GetMapping("/buscarPorCedula/{idPersona}")
	public String buscarPorCedula(@PathVariable("idPersona") String cedula, Model model) {
		Persona persona = this.iPersonaService.buscarPorCedula(cedula);
		model.addAttribute("persona", persona);
		return "vistaPersona";
	}

	// http://localhost:8080/personas/buscarTodos
	@GetMapping("/buscarTodos")
	public String buscarTodos(Model model) {
		List<Persona> lista = this.iPersonaService.buscarTodo();
		model.addAttribute("personas", lista);
		return "vistaListaPersonas";
	}

	// http://localhost:8080/personas/guardar
	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "redirect:/personas/buscarTodos";
	}

	// http://localhost:8080/personas/nuevo
	@GetMapping("/nuevo")
	public String mostrarNuevoEstudiante(Persona persona) {

		return "vistaNuevaPersona";
	}

	// Cuando viaja en el modelo en el request
	// http://localhost:8080/personas/actualizar/?
	@PutMapping("/actualizar/{idPersona}")
	public String actualizar(@PathVariable("idPersona") Integer id, Persona persona) {

		Persona perAux = this.iPersonaService.buscarPorId(id);
		perAux.setApellido(persona.getApellido());
		perAux.setNombre(persona.getNombre());
		perAux.setCedula(persona.getCedula());
		perAux.setGenero(persona.getGenero());
		this.iPersonaService.actualizar(perAux);
		return "redirect:/personas/buscarTodos";
	}

	// http://localhost:8080/personas/borrar
	@DeleteMapping("/borrar/{cedula}")
	public String borrar(@PathVariable("cedula") String cedula) {
		this.iPersonaService.borrar(cedula);
		return "redirect:/personas/buscarTodos";
	}

}