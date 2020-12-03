package net.e3.Tuiendaprueba;

import static org.junit.jupiter.api.Assertions.*;
import net.e3.Tuiendaprueba.entity.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class productoTest {
	@Autowired
	Producto producto = new Producto();

	
	//id
	@Test
	public void test() {
			Long id = producto.getId();
			String nombre= producto.getNombre(); 
			float precio= producto.getPrecio();
			String decripcion = producto.getDescripcion();
			String imagen1 = producto.getImagen1();
			String imagen2 = producto.getImagen2();
			String imagen3 = producto.getImagen3();
			int inicio = producto.getInicio();
			int cantidad = producto.getCantidad();
			int categoriaid = producto.getCategoriaid();
	}
	
	//id
	@Test
	public void testId() {
			String resultado = producto.setId(3);
			String esperado = "Se ingreso correctamente"; 
			assertEquals(resultado, esperado);
			
			String resultado2 = producto.setId(-1);
			String esperado2 = "No se puede ingresar"; 
			assertEquals(resultado2, esperado2);
	}
	
	//nombre
	@Test
	public void testNombre() {
			String nombre = producto.setNombre("");
			String esperando = "El nombre del producto no puede ser vacio"; 
			assertEquals(nombre, esperando);
			
			String nombre2 = producto.setNombre("Guitarra");
			String esperando2 = "El nombre es correcto";
			assertEquals(nombre2, esperando2);
	}
	
	//Precio
	@Test
	public void testPrecio() {
			String precio = producto.setPrecio(17);
			String precioesperado = "El precio es correcto"; 
			assertEquals(precio, precioesperado);
			
			String precio2 = producto.setPrecio(0);
			String precioesperado2 = "El precio no es correcto"; 
			assertEquals(precio2, precioesperado2);
	}
	
	//Descripcion
		@Test
		public void testDescripcion() {
				String descripcion = producto.setDescripcion("Producto nuevo");
				String desripcionesperando = "La descripcion es correcta"; 
				assertEquals(descripcion, desripcionesperando);
				
				String descripcion2= producto.setDescripcion("");
				String desripcionesperando2 = "La descripcion no puede estar en blanco"; 
				assertEquals(descripcion2, desripcionesperando2);
		}
		
		//imagenes
		@Test
		public void testImagene() {
			String esperando1 = "La imagen es correcta"; 
			String esperando2 = "La imagen no es correcta";
			
			String imagen1_1 = producto.setImagen1("12");
			String imagen1_2 = producto.setImagen1("");
			
			String imagen2_1 = producto.setImagen2("12");
			String imagen2_2 = producto.setImagen2("");
			
			String imagen3_1 = producto.setImagen3("12");
			String imagen3_2 = producto.setImagen3("");
				
				assertEquals(imagen1_1, esperando1);
				assertEquals(imagen1_2, esperando2);
				
				assertEquals(imagen2_1, esperando1);
				assertEquals(imagen2_2, esperando2);
				
				assertEquals(imagen3_1, esperando1);
				assertEquals(imagen3_2, esperando2);
			
		}
		
		//portada
		@Test
		public void testInicio() {
				String resultado = producto.setInicio(1);
				String esperado = "El producto esta en portada"; 
				assertEquals(resultado, esperado);
				
				String resultado2 = producto.setInicio(0);
				String esperado2 = "El producto no se encuentra en portada"; 
				assertEquals(resultado2, esperado2);
		}
		
		//Stock
		@Test
		public void testStock() {
				String resultado = producto.setCantidad(0);
				String esperado = "No existen productos en stock"; 
				assertEquals(resultado, esperado);
						
				String resultado2 = producto.setCantidad(100);
				String esperado2 = "Existen productos en Stock"; 
				assertEquals(resultado2, esperado2);
		}
		
		
		//Categoria
		@Test
		public void testCategoria() {
				String resultado = producto.setCategoriaid(1);
				String esperado = "La categoria es asignada correctamente"; 
				assertEquals(resultado, esperado);
								
				String resultado2 = producto.setCategoriaid(0);
				String esperado2 = "No tiene ninguna categoria asignada"; 
				assertEquals(resultado2, esperado2);
		}
		
		

}
