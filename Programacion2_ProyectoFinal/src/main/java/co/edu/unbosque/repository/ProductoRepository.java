package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Short> {

}
