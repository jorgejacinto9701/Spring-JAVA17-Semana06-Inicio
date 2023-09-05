package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Categoria;
import com.empresa.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<Categoria> listarTodo() {
		return repository.findAll();
	}
	
	
	
}
