package net.e3.Tuiendaprueba;

import static org.junit.jupiter.api.Assertions.*;

import net.e3.Tuiendaprueba.controller.CategoriaController;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

class categoriaTest {
	
	CategoriaController objCategoria;

	/*
	@Test
	void test() {
		fail("Not yet implemented");
	}
	*/
	
	String nombre = "marathon";
	
	@Test
	void testNombreNuevo() throws JsonMappingException, JsonProcessingException {
		String resultado = objCategoria.createCategoria(nombre);
		String esperado = "se agrega correctamente";
		assertEquals(esperado , resultado);
		
	}
	
	

}
