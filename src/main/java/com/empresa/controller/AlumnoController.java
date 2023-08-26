package com.empresa.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@Controller
public class AlumnoController {

	

	@Autowired
	private AlumnoService service;
	
	@RequestMapping("/verAlumno")
	public String ver() {
		return "registraAlumno";
	}
	
	@RequestMapping("/registraAlumno")
	@ResponseBody
	public HashMap<String, String> registra(Alumno obj){
		HashMap<String, String> salida = new HashMap<String, String>();
		Alumno objSalida =  service.insertaAlumno(obj);
		if (objSalida == null) {
			salida.put("mensaje", "Error al registrar");
		}else {
			salida.put("mensaje", "Registro exitoso");
		}
		return salida;
	}
}
