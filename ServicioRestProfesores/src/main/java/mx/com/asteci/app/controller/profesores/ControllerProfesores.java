package mx.com.asteci.app.controller.profesores;

import java.util.List;


import org.springframework.http.ResponseEntity;


import mx.com.asteci.app.model.Profesores;

public interface ControllerProfesores {
	

	public List<Profesores> visualizar();

	
	public ResponseEntity<?> addProfesores(Profesores profe);
	
	
	
	public ResponseEntity<?> deleteprofesor(int id);
	
	
	public ResponseEntity<?> editar( int id,Profesores profe);
	
	
	
}
