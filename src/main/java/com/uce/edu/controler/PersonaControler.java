package com.uce.edu.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.service.IPersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaControler {

	@Autowired
	private IPersonaService iPersonaService;

	// http://localhost:8080/personas/buscar
	@GetMapping("/buscar")
	public String buscarPorCedula(@RequestParam String cedula) {
		return new String();
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
	public String guardar() {
		// TODO: process POST request

		return "";
	}

	// http://localhost:8080/personas/actualizar
	@PutMapping("/actualizar")
	public String actualizar() {
		// TODO: process PUT request

		return "";
	}

	// http://localhost:8080/personas/borrar
	@DeleteMapping("/borrar")
	public String borrar() {
		return "";
	}

}
