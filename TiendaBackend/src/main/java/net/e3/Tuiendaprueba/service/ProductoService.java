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

import net.e3.Tuiendaprueba.entity.Producto;
import net.e3.Tuiendaprueba.exception.RecordNotFoundException;
import net.e3.Tuiendaprueba.repository.ProductoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository repo;

	public List<Producto> getAll(){
		List<Producto> productoList = repo.findAll();
		if(productoList.size() > 0) {
			return productoList;
		} else {
			return new ArrayList<Producto>();
		}
	}
     		
	public Producto findById(Long id) throws RecordNotFoundException{
		Optional<Producto> producto = repo.findById(id);
		if(producto.isPresent()) {
			return producto.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Producto createProducto(Producto producto){
		return repo.save(producto);
	}

	public Producto updateProducto(Producto producto) throws RecordNotFoundException {
		Optional<Producto> productoTemp = repo.findById(producto.getId());
	
		if(productoTemp.isPresent()){
			return repo.save(producto);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteProductoById(Long id) throws RecordNotFoundException{
		Optional<Producto> producto = repo.findById(id);
		if(producto.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
