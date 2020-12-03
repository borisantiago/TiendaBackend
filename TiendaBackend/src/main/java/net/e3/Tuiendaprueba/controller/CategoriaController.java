
package net.e3.Tuiendaprueba.controller;

import net.e3.Tuiendaprueba.entity.Categoria;
import net.e3.Tuiendaprueba.exception.RecordNotFoundException;
import net.e3.Tuiendaprueba.service.CategoriaService;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CategoriaController {
	@Autowired
	CategoriaService service;
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> getAll() {
		List<Categoria> list = service.getAll();
		return new ResponseEntity<List<Categoria>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Categoria entity = service.findById(id);
		return new ResponseEntity<Categoria>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/categoria")
	//public ResponseEntity<Categoria> createCategoria(@RequestParam("categoria") String s)throws JsonMappingException, JsonProcessingException{
	
	public String createCategoria(@RequestParam("categoria") String s)throws JsonMappingException, JsonProcessingException{
		
		ObjectMapper om = new ObjectMapper();
		Categoria categoria=om.readValue(s, Categoria[].class)[0];
				
		if(service.findCategoria(categoria)==null) {
			//service.createCategoria(categoria);
			//return new ResponseEntity<Categoria>(categoria, new HttpHeaders(), HttpStatus.OK);
			return "se agrega correctamente";
		}else {
			return "el nombre ya existe, no se puede guardar"; 
		}
			
	}

	@PutMapping("/categoria")
	public ResponseEntity<Categoria> updateCategoria(@RequestParam("categoria") String s) throws RecordNotFoundException, JsonMappingException, JsonProcessingException{
		ObjectMapper om = new ObjectMapper();
		Categoria categoria=om.readValue(s, Categoria[].class)[0];
		
		service.updateCategoria(categoria);
		return new ResponseEntity<Categoria>(categoria, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/categoria/{id}")
	public HttpStatus deleteCategoriaById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteCategoriaById(id);
		return HttpStatus.OK;
	}
}				
