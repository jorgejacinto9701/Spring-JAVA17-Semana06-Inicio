package com.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlumnoController {

	
	@GetMapping(value = "/verAlumno" )
	public String ver() {
		return "registraAlumno";
	}
	

}
