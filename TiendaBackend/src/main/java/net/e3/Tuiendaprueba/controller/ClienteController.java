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
package net.e3.Tuiendaprueba.controller;


import net.e3.Tuiendaprueba.entity.Cliente;
import net.e3.Tuiendaprueba.exception.RecordNotFoundException;
import net.e3.Tuiendaprueba.service.ClienteService;

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
public class ClienteController {
	@Autowired
	ClienteService service;
	
	@GetMapping("/cliente")
	public ResponseEntity<List<Cliente>> getAll() {
		List<Cliente> list = service.getAll();
		return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Cliente entity = service.findById(id);
		return new ResponseEntity<Cliente>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/cliente")
	public ResponseEntity<Cliente> createCliente(@RequestParam("cliente") String s)throws JsonMappingException, JsonProcessingException{
		
		ObjectMapper om = new ObjectMapper();
		Cliente cliente=om.readValue(s, Cliente[].class)[0];

		
		service.createCliente(cliente);
		return new ResponseEntity<Cliente>(cliente, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/cliente")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) throws RecordNotFoundException{
		service.updateCliente(cliente);
		return new ResponseEntity<Cliente>(cliente, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/cliente/{id}")
	public HttpStatus deleteClienteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteClienteById(id);
		return HttpStatus.OK;
	}
}				
