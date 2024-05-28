package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.EntidadFinanciera;

@Repository
public interface EntidadFinancieraRepository extends CrudRepository<EntidadFinanciera, Short>{

}
