package mx.com.asteci.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.com.asteci.app.model.Profesores;


public class DatosProfesores {
	
	 private List<Profesores> listaModelo = new ArrayList<>(Arrays.asList(

	            new Profesores(0, "Alejandra", "Ortiz","Vazquez","2133046510"),
	            new Profesores(1, "Ricardo", "Ortiz","Vazquez","2133046510")
	          
	    ));

	public List<Profesores> getListaModelo() {
		return listaModelo;
	}

	public void setListaModelo(List<Profesores> listaModelo) {
		this.listaModelo = listaModelo;
	}

	 
	 
	 
}
