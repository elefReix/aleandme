package mx.com.asteci.app.productos.models.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "propiedades")
public class Propiedades {

	private String agregadoExito;
	private String borradoExito;
	private String borradoError;
	private String editadoExito;
	private String agregagoError;
	private String editadoError;

	private String titulo;
	private  String version;
	private String descripcion;

	private String nombre;
	private String url;
	private String licencia;
	
	private String direccion;
}
