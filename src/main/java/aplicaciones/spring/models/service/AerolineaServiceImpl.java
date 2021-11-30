package aplicaciones.spring.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.models.entity.Aerolinea;
import aplicaciones.spring.models.repository.AerolineaRepository;

@Service
public class AerolineaServiceImpl implements IAerolineaService{
	@Autowired
	private AerolineaRepository aerolineaRepository;
	
	@Override
	public List<Aerolinea> listarTodos() {
		return (List<Aerolinea>) aerolineaRepository.findAll();
	}

	@Override
	public void guardar(Aerolinea aerolinea) {
		aerolineaRepository.save(aerolinea);
	}

	@Override
	public Aerolinea buscarPorId(Long id) {
		return aerolineaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		aerolineaRepository.deleteById(id);	
	}

}
