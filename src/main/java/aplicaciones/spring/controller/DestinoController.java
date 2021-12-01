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
import aplicaciones.spring.models.entity.Destino;
import aplicaciones.spring.models.service.IAerolineaService;
import aplicaciones.spring.models.service.IDestinoService;

@Controller
@RequestMapping("/destinos")
public class DestinoController {
	@Autowired
	private IDestinoService destinoService;
	
	@Autowired
	private IAerolineaService aerolineService;
	
	@GetMapping("/listar")
	public String listarDestinos(Model model) {
		List<Destino> listadoDestinos = destinoService.listarTodos();
		model.addAttribute("titulo", "Destinos");
		model.addAttribute("destinos", listadoDestinos);
		return "listarDestinos";
	}
	@GetMapping("/registrar")
	public String crear(Model model) {
		
		List<Aerolinea> listaAerolineas = aerolineService.listarTodos();
		Destino destino = new Destino();
		model.addAttribute("titulo", "Registrar nuevo Destino");
		model.addAttribute("destino", destino);
		model.addAttribute("aerolineas", listaAerolineas);
		return "formDestino";
	}
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Destino destino) {
		destinoService.guardar(destino);
		return "redirect:/destinos/listar";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idDestino, Model model) {
		Destino destino = destinoService.buscarPorId(idDestino);
		model.addAttribute("titulo", "Editar Destino");
		model.addAttribute("destino", destino);
		return "formDestino";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long idDestino) {
		destinoService.eliminar(idDestino);
		return "redirect:/destinos/listar";
	}
}
