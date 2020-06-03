package mx.com.asteci.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
	String mensaje;
	String codigo;
	Profesores prof;
	


}
