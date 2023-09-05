package com.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistraModalidadController {

		
	@GetMapping(value = "/verRegistraModalidad" )
	public String verAlumno() {return "registraModalidad";}
	
	
			
	
}







