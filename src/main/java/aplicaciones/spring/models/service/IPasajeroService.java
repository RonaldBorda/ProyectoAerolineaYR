package aplicaciones.spring.models.service;

import java.util.List;

import aplicaciones.spring.models.entity.Pasajero;

public interface IPasajeroService {
	public List<Pasajero> listarTodos();
	public void guardar(Pasajero pasajero);
	public Pasajero buscarPorId(Long id);
	public void eliminar(Long id);
}
