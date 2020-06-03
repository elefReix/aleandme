package mx.com.asteci.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.asteci.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
