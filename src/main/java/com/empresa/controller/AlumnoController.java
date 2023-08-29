package com.empresa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService service;
	
	@GetMapping(value = "/verAlumno" )
	public String verAlumno() {return "registraAlumno";}

	@GetMapping(value = "/verConcurso" )
	public String verConcurso() {return "registraConcurso";}

	@GetMapping(value = "/verJugador" )
	public String verJugador() {return "registraJugador";}


	@PostMapping("/registraAlumno")
	@ResponseBody
	public Map<?, ?> registra(Alumno obj){
		HashMap<String, String> map = new HashMap<String, String>();
		Alumno objSalida = service.insertaAlumno(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		}else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	
	

}
