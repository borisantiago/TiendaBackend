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

import net.e3.Tuiendaprueba.entity.Categoria;
import net.e3.Tuiendaprueba.exception.RecordNotFoundException;
import net.e3.Tuiendaprueba.repository.CategoriaRepository;

import org.springframework.stereotype.Service;



import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;

	public List<Categoria> getAll(){
		List<Categoria> categoriaList = repo.findAll();
		if(categoriaList.size() > 0) {
			return categoriaList;
		} else {
			return new ArrayList<Categoria>();
		}
	}
     		
	public Categoria findById(Long id) throws RecordNotFoundException{
		Optional<Categoria> categoria = repo.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Categoria createCategoria(Categoria categoria){
		return repo.save(categoria);
	}

	public Categoria updateCategoria(Categoria categoria) throws RecordNotFoundException {
		Optional<Categoria> categoriaTemp = repo.findById(categoria.getId());
	
		if(categoriaTemp.isPresent()){
			return repo.save(categoria);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteCategoriaById(Long id) throws RecordNotFoundException{
		Optional<Categoria> categoria = repo.findById(id);
		if(categoria.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
