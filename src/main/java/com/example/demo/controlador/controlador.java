package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interservice.Imascotaservice;
import com.example.demo.modelo.Mascota;

@Controller
@RequestMapping
public class controlador {

	@Autowired
	private Imascotaservice service;

	@GetMapping("/listar")
	public String listar(Model model) {

		List<Mascota> mascotas = service.listar();
		model.addAttribute("mascotas", mascotas);
		return "index";

	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("mascota", new Mascota());
		return "form";

	}

	@PostMapping("/save")
	public String save(@Validated Mascota m, Model mode) {
		service.save(m);
		return "redirect:/listar";

	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Mascota> mascota = service.listarId(id);
		model.addAttribute("mascota", mascota);
		return "form";

	}
    
	@GetMapping("/eliminar/{id}")
	public String delete(Model model,@PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";

	}

}
