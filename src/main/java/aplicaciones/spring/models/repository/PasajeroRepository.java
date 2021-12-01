package aplicaciones.spring.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.models.entity.Pasajero;

@Repository
public interface PasajeroRepository extends CrudRepository<Pasajero, Long> {
	
}
