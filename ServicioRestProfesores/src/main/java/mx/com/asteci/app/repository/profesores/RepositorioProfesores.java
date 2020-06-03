package mx.com.asteci.app.repository.profesores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.asteci.app.model.Profesores;
import mx.com.asteci.data.DatosProfesores;


public class RepositorioProfesores {

	
	DatosProfesores datos;
	@Autowired
	
	private List<Profesores> listaProfesores;
	
	public RepositorioProfesores(DatosProfesores datos) {
		listaProfesores=datos.getListaModelo();
	}
	
	
	public void registrar(Profesores profe) {
		listaProfesores.add(profe);
		
	}

	public void editar(Profesores profe) {
		int id=profe.getId();
		listaProfesores.set(id, profe);
		
	}
	public void borrar(int id) {
		listaProfesores.remove(id);
		
	}

	public void visualizar() {
		for(Profesores emp:listaProfesores) {
			System.out.println(emp.toString());

		}
		
		
	}


	
	
	
	



}
