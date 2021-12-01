package aplicaciones.spring.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.models.entity.Pasajero;
import aplicaciones.spring.models.repository.PasajeroRepository;

@Service
public class PasajeroServiceImpl implements IPasajeroService{
	@Autowired
	private PasajeroRepository pasajeroRepository;
	
	@Override
	public List<Pasajero> listarTodos() {
		return (List<Pasajero>) pasajeroRepository.findAll();
	}

	@Override
	public void guardar(Pasajero pasajero) {
		pasajeroRepository.save(pasajero);
	}

	@Override
	public Pasajero buscarPorId(Long id) {
		return pasajeroRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		pasajeroRepository.deleteById(id);	
	}

}
