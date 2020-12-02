																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Sun Aug 09 00:26:19 COT 2020
| 
 -------------------------------------------------------------------
																*/
package net.e3.Tuiendaprueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;
import javax.annotation.PostConstruct;					

@SpringBootApplication
public class TuiendapruebaApplication {
	public static void main(String[] args) {
		SpringApplication.run(TuiendapruebaApplication.class, args);
		System.out.println("Active resources for Categoria entity");
		System.out.println("GET");
		System.out.println("/api/v1/categoria");
		System.out.println("/api/v1/categoria/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/categoria");
		System.out.println("PUT");
		System.out.println("/api/v1/categoria");
		System.out.println("DELETE");
		System.out.println("/api/v1/categoria/{id}");
		System.out.println("Active resources for Producto entity");
		System.out.println("GET");
		System.out.println("/api/v1/producto");
		System.out.println("/api/v1/producto/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/producto");
		System.out.println("PUT");
		System.out.println("/api/v1/producto");
		System.out.println("DELETE");
		System.out.println("/api/v1/producto/{id}");
		System.out.println("Active resources for Cliente entity");
		System.out.println("GET");
		System.out.println("/api/v1/cliente");
		System.out.println("/api/v1/cliente/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/cliente");
		System.out.println("PUT");
		System.out.println("/api/v1/cliente");
		System.out.println("DELETE");
		System.out.println("/api/v1/cliente/{id}");
	}
	
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}						
}
