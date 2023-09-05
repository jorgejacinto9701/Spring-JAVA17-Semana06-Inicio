package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
