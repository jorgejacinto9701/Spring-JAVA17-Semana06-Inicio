package com.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoCrudController {


	@GetMapping("/verCrudEmpleado")
	public String verInicio() {
		return "crudEmpleado";
	}
	
}
