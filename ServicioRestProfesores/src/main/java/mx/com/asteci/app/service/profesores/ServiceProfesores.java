package mx.com.asteci.app.service.profesores;

import mx.com.asteci.app.model.Profesores;

public interface ServiceProfesores {
	public void registrar(Profesores Profesor);


	public void editar(Profesores profesor);


	public void borrar(Profesores profesor);
}
