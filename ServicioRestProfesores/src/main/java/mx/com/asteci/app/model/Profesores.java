package mx.com.asteci.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesores {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Nombre es obligatorio")
	private String name;

	@NotBlank(message = "Correo es obligatorio")
	private String email;

	@NotBlank(message = "Apellidos es obligatorio")
	private String apellidos;

	@NotBlank(message = "Matricula es obligatorio")
	private String matricula;



	
	
	
	
	
	

}
