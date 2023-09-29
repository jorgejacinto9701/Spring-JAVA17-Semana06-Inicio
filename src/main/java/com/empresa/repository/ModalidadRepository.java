package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>{

	
	public List<Modalidad> findByNombreIgnoreCase(String nombre);
	public List<Modalidad> findByNombreLike(String nombre);

	@Query("select x from Modalidad x where x.sede = ?1 and x.deporte.idDeporte =?2")
	public List<Modalidad> buscaPorDeporteEnSede(String sede, int idDeporte);
}