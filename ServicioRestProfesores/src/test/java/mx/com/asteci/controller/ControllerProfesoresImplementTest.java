package mx.com.asteci.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import mx.com.asteci.app.ServicioRestProfesoresApplication;

public class ControllerProfesoresImplementTest extends ServicioRestProfesoresApplication {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(get("/profesores")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.id").value("1")).andExpect(jsonPath("$.name").value("ale"))
				.andExpect(jsonPath("$.email").value("ale@gmail.com")).andExpect(jsonPath("$.apellidos").value("ortiz")).andExpect(jsonPath("$.matricula").value("2133046510"));

	}
	
}
