package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Pais;
import com.empresa.entity.Tipo;
import com.empresa.service.PaisService;
import com.empresa.service.TipoService;

@Controller
public class UtilController {

	@Autowired
	private PaisService paisService;
	
	@Autowired
	private TipoService tipoService;
	
	
	@GetMapping(value = "/listaPais")
	@ResponseBody
	public List<Pais> cargaPais(){
		return paisService.listaPais();
	}
	
	@GetMapping(value = "/listaTipo")
	@ResponseBody
	public List<Tipo> cargaTipo(){
		return tipoService.listaTipo();
	}
	
	
}
