package mx.com.asteci.app.productos.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
	
	String mensaje;
	Producto producto;

}
