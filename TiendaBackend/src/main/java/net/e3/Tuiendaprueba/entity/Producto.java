																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. G�mez (2020)
| File Date: Sun Aug 09 00:26:19 COT 2020
| 
 -------------------------------------------------------------------
																*/
package net.e3.Tuiendaprueba.entity;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.Id;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private float precio;
	private String descripcion;
	
	//@Type(type = "uuid-char")
	private String imagen1;
	
	//@Type(type = "uuid-char")
	private String imagen2;
	
	//@Type(type = "uuid-char")
	private String imagen3;
	
	private int inicio;
	private int cantidad;
	
	private int categoriaid;
	
	public Long getId() {
		return id;
	}
	
	/*
	public void setId(Long id) {
		this.id = id;
	}
	*/
	
	public String setId(int id) {
		if(id > 0) {
			//this.id = id;
			return "Se ingreso correctamente";
		}else {
			return "No se puede ingresar";
		}
	}
	
 
	
	public String getNombre() {
		return nombre;
	}
	
	public String setNombre(String nombre) {
		if(nombre == ""){
			this.nombre = nombre;
			return "El nombre del producto no puede ser vacio";
		}else {
			return "El nombre es correcto";
		}
		
	}
	
	public float getPrecio() {
		return precio;
	}
	
	/*
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	*/
	
	//precio
	public String setPrecio(float precio) {
		if(precio == 0) {
			this.precio = precio;
			return "El precio no es correcto";
		}else { 
			return "El precio es correcto";
		}
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String setDescripcion(String descripcion) {
		if(descripcion != "") {
			this.descripcion = descripcion;
			return "La descripcion es correcta";
		}
		else {
		return "La descripcion no puede estar en blanco";
		}
	}
	
	public String getImagen1() {
		return imagen1;
	}
	
	public String setImagen1(String imagen1) {
		if(imagen1 != "") {
			this.imagen1 = imagen1;
			return "La imagen es correcta";
	}
		else {
		return "La imagen no es correcta";
		}
	}

	
	public String getImagen2() {
		return imagen2;
	}
	
	public String setImagen2(String imagen2) {
		if(imagen2 != "") {
			this.imagen2 = imagen2;
			return "La imagen es correcta";
		}
		else {
		return "La imagen no es correcta";
		}
	}
	
	public String getImagen3() {
		return imagen3;
	}
	
	public String setImagen3(String imagen3) {
		if(imagen3 != "") {
			this.imagen3 = imagen3;
			return "La imagen es correcta";
		}
		else {
		return "La imagen no es correcta";
		}
	}
	
	public int getInicio() {
		return inicio;
	}
	
	public String setInicio(int inicio) {
		if(inicio == 1) {
			this.inicio = inicio;
			return "El producto esta en portada";
		}
		else {
		return "El producto no se encuentra en portada";
		}
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public String setCantidad(int cantidad) {
		if(cantidad == 0) {
			this.cantidad = cantidad;
			return "No existen productos en stock";
		}
		else {
		return "Existen productos en Stock";
		}
	}
	
	public int getCategoriaid() {
		return categoriaid;
	}
	
	public String setCategoriaid(int categoriaid) {
		if(categoriaid != 0) {
			this.categoriaid = categoriaid;
			return "La categoria es asignada correctamente";
		}
		else {
		return "No tiene ninguna categoria asignada";
		}
	}

	
	
}
