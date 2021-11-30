package aplicaciones.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import aplicaciones.spring.models.entity.Destino;
import aplicaciones.spring.models.service.IDestinoService;

@Controller
@RequestMapping("/destinos")
public class DestinoController {
	@Autowired
	private IDestinoService destinoService;
	@GetMapping("/listar")
	public String listarDestinos(Model model) {
		List<Destino> listadoDestinos = destinoService.listarTodos();
		model.addAttribute("titulo", "Destinos");
		model.addAttribute("destinos", listadoDestinos);
		return "listarDestinos";
	}
	@GetMapping("/registrar")
	public String crear(Model model) {
		Destino destino = new Destino();
		model.addAttribute("titulo", "Registrar nuevo Destino");
		model.addAttribute("destino", destino);
		return "formDestino";
	}
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Destino destino) {
		destinoService.guardar(destino);
		return "redirect:/destinos/listar";
	}
}
