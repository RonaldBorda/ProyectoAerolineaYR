package aplicaciones.spring.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.models.entity.Destino;
@Repository
public interface DestinoRepository extends CrudRepository<Destino, Long> {

}
