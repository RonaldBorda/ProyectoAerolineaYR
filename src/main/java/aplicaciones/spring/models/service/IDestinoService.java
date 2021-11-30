package aplicaciones.spring.models.service;

import java.util.List;


import aplicaciones.spring.models.entity.Destino;

public interface IDestinoService {
	public List<Destino> listarTodos();
	public void guardar(Destino destino);
	public Destino buscarPorId(Long id);
	public void eliminar(Long id);
}
