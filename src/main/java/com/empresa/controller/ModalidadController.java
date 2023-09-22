package com.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModalidadController {


	@RequestMapping("/verCrudModalidad")
	public String verInicio() {
		return "crudModalidad";
	}
	
	
}