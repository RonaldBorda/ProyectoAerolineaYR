package aplicaciones.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aplicaciones.spring.models.entity.Pasajero;
import aplicaciones.spring.models.service.IPasajeroService;

@Controller

@RequestMapping("/pasajeros")
public class PasajeroController {
	@Autowired
	private IPasajeroService pasajeroService;
	@GetMapping("/listar")
	public String listarPasajero(Model model) {
		List<Pasajero> listadoPasajeros = pasajeroService.listarTodos();
		model.addAttribute("titulo", "Pasajeros");
		model.addAttribute("pasajeros", listadoPasajeros);
		return "listarPasajeros";	
	}
	
	@GetMapping("/registrar")
	public String crear(Model model) {
		Pasajero pasajero = new Pasajero();
		model.addAttribute("titulo", "Registrar pasajero");
		model.addAttribute("pasajero", pasajero);
		return "formPasajero";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Pasajero pasajero) {
		pasajeroService.guardar(pasajero);
		return "redirect:/pasajeros/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idPasajero, Model model) {
		Pasajero pasajero = pasajeroService.buscarPorId(idPasajero);
		model.addAttribute("titulo", "Editar Pasajero");
		model.addAttribute("pasajero", pasajero);
		return "formPasajero";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long idPasajero) {
		pasajeroService.eliminar(idPasajero);
		return "redirect:/pasajeros/listar";
	}
}
