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
package net.e3.Tuiendaprueba.service;

import net.e3.Tuiendaprueba.entity.Cliente;
import net.e3.Tuiendaprueba.exception.RecordNotFoundException;
import net.e3.Tuiendaprueba.repository.ClienteRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;

	public List<Cliente> getAll(){
		List<Cliente> clienteList = repo.findAll();
		if(clienteList.size() > 0) {
			return clienteList;
		} else {
			return new ArrayList<Cliente>();
		}
	}
     		
	public Cliente findById(Long id) throws RecordNotFoundException{
		Optional<Cliente> cliente = repo.findById(id);
		if(cliente.isPresent()) {
			return cliente.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Cliente createCliente(Cliente cliente){
		return repo.save(cliente);
	}

	public Cliente updateCliente(Cliente cliente) throws RecordNotFoundException {
		Optional<Cliente> clienteTemp = repo.findById(cliente.getId());
	
		if(clienteTemp.isPresent()){
			return repo.save(cliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteClienteById(Long id) throws RecordNotFoundException{
		Optional<Cliente> cliente = repo.findById(id);
		if(cliente.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
