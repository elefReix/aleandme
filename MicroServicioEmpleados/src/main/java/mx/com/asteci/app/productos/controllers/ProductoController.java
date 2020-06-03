package mx.com.asteci.app.productos.controllers;
import mx.com.asteci.app.productos.models.entity.*;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mx.com.asteci.app.app.productos.models.service.IProductoService;
import mx.com.asteci.app.productos.models.entity.Producto;

@RestController
public class ProductoController {
	
	//@Autowired
	//private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private Propiedades propiedades;
	
	@GetMapping("/productos")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			logger.info("Se visualizan lo productos");
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/productos/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
		logger.info("Se visualizan el producto con el id: "+id);

		
		/*
		 * try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return producto;
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Status crear(@RequestBody Producto producto) {
		Status status=new Status();
		logger.info("Se crea un producto");
		productoService.save(producto);
		status.setMensaje(propiedades.getAgregadoExito());
		status.setProducto(producto);

		return status;
		
	}
	
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Status editar(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoDb = productoService.findById(id);
		Status status=new Status();

		productoDb.setNombre(producto.getNombre());
        productoDb.setPrecio(producto.getPrecio());
		logger.info("Se edita  un productos");
		productoService.save(productoDb);
        status.setMensaje(propiedades.getEditadoExito());
        status.setProducto(producto);
        return status;
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Status eliminar(@PathVariable Long id) {
		Status status=new Status();
		logger.info("Se elimina uno de lo productos con el id: "+id);
		productoService.deleteById(id);
		status.setMensaje(propiedades.getBorradoExito());
		return status;
	}
	

}
