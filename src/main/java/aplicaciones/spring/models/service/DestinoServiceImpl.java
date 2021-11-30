package aplicaciones.spring.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.models.entity.Destino;
import aplicaciones.spring.models.repository.DestinoRepository;
@Service
public class DestinoServiceImpl implements IDestinoService{
	@Autowired
	private DestinoRepository destinoRepository;
	
	@Override
	public List<Destino> listarTodos() {
		return (List<Destino>) destinoRepository.findAll();
	}

	@Override
	public void guardar(Destino destino) {
		destinoRepository.save(destino);
	}

	@Override
	public Destino buscarPorId(Long id) {
		return destinoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		destinoRepository.deleteById(id);
	}

}
