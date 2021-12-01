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

import aplicaciones.spring.models.entity.Aerolinea;
import aplicaciones.spring.models.service.IAerolineaService;

@Controller
@RequestMapping("/aerolineas")
public class AerolineaController {
	@Autowired
	private IAerolineaService aerolineaService;
	@GetMapping("/listar")
	public String listarAerolinea(Model model) {
		List<Aerolinea> listadoAerolineas = aerolineaService.listarTodos();
		model.addAttribute("titulo","Aerolineas");
		model.addAttribute("aerolineas",listadoAerolineas);
		return "listarAerolineas";
	}
	@GetMapping("/registrar")
	public String crear(Model model) {
		Aerolinea aerolinea = new Aerolinea();
		model.addAttribute("titulo", "Registrar nueva Aerolinea");
		model.addAttribute("aerolinea", aerolinea);
		return "formAerolinea";
	}
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Aerolinea aerolinea) {
		aerolineaService.guardar(aerolinea);
		return "redirect:/aerolineas/listar";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idAerolinea, Model model) {
		Aerolinea aerolinea = aerolineaService.buscarPorId(idAerolinea);
		model.addAttribute("titulo", "Editar Aerolinea");
		model.addAttribute("aerolinea", aerolinea);
		return "formAerolinea";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long idAerolinea, Model model) {
		try {
			aerolineaService.eliminar(idAerolinea);
			return "redirect:/aerolineas/listar";		
		} catch(Exception e) {
			return "redirect:/aerolineas/listar";	
		}
	}
	
}
