package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Tipo;
import com.empresa.repository.TipoRepository;

@Service
public class TipoServiceImpl implements TipoService{

	@Autowired
	private TipoRepository repository;
	
	@Override
	public List<Tipo> listaTipo() {
		return repository.findAll();
	}

	
}
