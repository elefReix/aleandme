package mx.com.asteci.app.service.profesores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.asteci.app.model.Profesores;
import mx.com.asteci.app.model.Propiedades;
import mx.com.asteci.app.repository.profesores.RepositorioProfesores;
import mx.com.asteci.app.repository.profesores.RepositoryProfesoresImpl;

@Service
public class ServiceProfesoresImplement implements ServiceProfesores {
	
	@Autowired
	RepositoryProfesoresImpl repo;
	
	@Autowired
	Propiedades propiedades;
	
	
	public void registrar(Profesores profesor) {
		if(profesor.getName().isEmpty() || profesor.getApellidos().isEmpty() || profesor.getMatricula().isEmpty()) {
			System.out.println(propiedades.getAgregagoError());

		}else {
			//repo.registrar(profesor);
			repo.save(profesor);
			System.out.println(propiedades.getAgregadoExito());

		}
		
		
	}
	
	

	@Override
	public void editar(Profesores profesor) {
		if(profesor.getName().isEmpty() || profesor.getApellidos().isEmpty() || profesor.getMatricula().isEmpty()) {
			System.out.println(propiedades.getEditadoError());


		}else {
			//repo.editar(profesor);
			repo.save(profesor);
			System.out.println(propiedades.getEditadoExito());

		}
		
	}

	@Override
	public void borrar(Profesores profesor) {
		if(profesor.getName().isEmpty() || profesor.getApellidos().isEmpty() || profesor.getMatricula().isEmpty()) {
			System.out.println(propiedades.getBorradoError());

		}else {
			//repo.borrar(profesor.getId());
			repo.delete(profesor);
			System.out.println(propiedades.getBorradoExito());

		}
		
	}

}
