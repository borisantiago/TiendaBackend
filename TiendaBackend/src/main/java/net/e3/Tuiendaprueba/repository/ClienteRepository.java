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
package net.e3.Tuiendaprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.e3.Tuiendaprueba.entity.Cliente;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional <Cliente> findById(Long id);
	
	@Transactional
	void deleteById(Long id);
	
}
