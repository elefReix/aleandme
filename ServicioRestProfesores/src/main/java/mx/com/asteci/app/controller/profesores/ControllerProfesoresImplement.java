package mx.com.asteci.app.controller.profesores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.asteci.app.model.Profesores;
import mx.com.asteci.app.model.Propiedades;
import mx.com.asteci.app.model.Status;
import mx.com.asteci.app.service.profesores.ServiceProfesoresImplement;

@RestController
@RequestMapping("/profe")
public class ControllerProfesoresImplement extends  SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(ControllerProfesoresImplement.class);
	
	

	@Autowired
	private  ServiceProfesoresImplement profesService;

	@Autowired
	Propiedades propiedades;


	@Autowired
	public ControllerProfesoresImplement(ServiceProfesoresImplement profeRepository) {
		this.profesService = profeRepository;
		logger.info("Se agrego el profesor");
	}

	List<Profesores> listaProfesores = new ArrayList<Profesores>();

	
	
	
	
	
	@RequestMapping(value = "/profesores", method = RequestMethod.GET)
	@ApiOperation(value="Obtiene todos los Profesores",notes="Recupera toda la informacion de los Profesores")
	@ApiResponses({
		@ApiResponse(code=200,message="Exito"),
		@ApiResponse(code=400,message="Solicitud incorrecta"),
		@ApiResponse(code=404,message="Extraviado"),
		@ApiResponse(code=500,message="Fracaso"),})
	public @ResponseBody List<Profesores> visualizar() {
		List<Profesores> res = listaProfesores;
		logger.info("se visualizaron todos los profesores");
		
		return res;

	}

	@RequestMapping(value = "/profesores", method = RequestMethod.POST)
	@ApiOperation(value="Agregar un Profesor",notes="Agrega toda la informacion de los Profesores")
	@ApiResponses({
		@ApiResponse(code=200,message="Exito"),
		@ApiResponse(code=400,message="Solicitud incorrecta"),
		@ApiResponse(code=404,message="Extraviado"),
		@ApiResponse(code=500,message="Fracaso"),})
	
	public ResponseEntity<?> addProfesores(@RequestBody Profesores profe) {
		if(profe.getName().isEmpty()||profe.getApellidos().isEmpty()|| profe.getEmail().isEmpty()|| profe.getMatricula().isEmpty()) {
			logger.info("no se agregan los profesores");
			 return ResponseEntity.badRequest()
					    .body(new Status(propiedades.getAgregagoError(), "50", profe));
		}else {

			profesService.registrar(profe);
			listaProfesores.add(profe);
			logger.info("se agregan los profesores");

		}
		 return ResponseEntity.status(HttpStatus.OK)
			        .body(new Status(propiedades.getAgregadoExito(), "200", profe));

	}
	
	
	
	@RequestMapping(value = "/profesores/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value="Eliminacion de un profesor",notes="Elimina a un profesor por su id")
	@ApiResponses({
		@ApiResponse(code=200,message="Exito"),
		@ApiResponse(code=400,message="Solicitud incorrecta"),
		@ApiResponse(code=404,message="Extraviado"),
		@ApiResponse(code=500,message="Fracaso"),})
	public ResponseEntity<?> deleteprofesor(@PathVariable int id) {
		Profesores profesor=new Profesores();
		if(id<=0) {
			logger.info("el id no es correcto"+id);
			 return ResponseEntity.badRequest()
					    .body(new Status(propiedades.getBorradoError(), "50", profesor));
		}else {
			listaProfesores.remove(id);
			System.out.print(propiedades.getBorradoExito());
			logger.info("se elimino el profesor con el id"+id);

			return ResponseEntity.status(HttpStatus.OK).body(new Status(propiedades.getBorradoExito(), "200", profesor));

			
		}
		
		
	}
	
	
	
	@RequestMapping(value = "/profesores/{id}", method = RequestMethod.PUT)
	@ApiOperation(value="Edita a un profesor",notes="Edicion de un profesor mediante su id")
	@ApiResponses({
		@ApiResponse(code=200,message="Exito"),
		@ApiResponse(code=400,message="Solicitud incorrecta"),
		@ApiResponse(code=404,message="Extraviado"),
		@ApiResponse(code=500,message="Fracaso"),})
	public ResponseEntity<?> editar(@PathVariable int id,@RequestBody Profesores profe) {

		if(id<=0||profe.getName().isEmpty()||profe.getApellidos().isEmpty()|| profe.getEmail().isEmpty()|| profe.getMatricula().isEmpty()) {
			logger.info("no se editan los profesores");

			return ResponseEntity.badRequest()
					    .body(new Status("llene bien los campos", "50", profe));
		}else {


			profesService.editar(profe);
				listaProfesores.set(id, profe);
				logger.info("se editaron los profesores");

		}
		logger.info("se editaron los profesores");

		 return ResponseEntity.status(HttpStatus.OK)
			        .body(new Status("Profesor Modificado", "50", profe));


	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Profesores> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(List<Profesores> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

}
