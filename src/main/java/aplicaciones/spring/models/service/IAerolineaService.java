package aplicaciones.spring.models.service;

import java.util.List;

import aplicaciones.spring.models.entity.Aerolinea;

public interface IAerolineaService {
	public List<Aerolinea> listarTodos();
	public void guardar(Aerolinea aerolinea);
	public Aerolinea buscarPorId(Long id);
	public void eliminar(Long id);
}
