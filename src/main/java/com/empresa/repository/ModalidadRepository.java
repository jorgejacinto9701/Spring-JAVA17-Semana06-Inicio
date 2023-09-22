package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>{

	
	public List<Modalidad> findByNombreIgnoreCase(String nombre);
	public List<Modalidad> findByNombreLike(String nombre);
	
}