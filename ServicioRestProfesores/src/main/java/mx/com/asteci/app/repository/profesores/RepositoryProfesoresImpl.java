package mx.com.asteci.app.repository.profesores;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.asteci.app.model.Profesores;

@Repository
public interface RepositoryProfesoresImpl extends CrudRepository<Profesores, Long>{
	
	List<Profesores> findByName(String name);
	
	

}
