package aplicaciones.spring.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.models.entity.Aerolinea;

@Repository
public interface AerolineaRepository extends CrudRepository<Aerolinea, Long> {
	
}
