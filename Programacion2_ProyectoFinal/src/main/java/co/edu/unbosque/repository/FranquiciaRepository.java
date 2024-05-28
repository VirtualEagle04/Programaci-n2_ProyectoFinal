package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Franquicia;

@Repository
public interface FranquiciaRepository extends CrudRepository<Franquicia, Short>{

}
