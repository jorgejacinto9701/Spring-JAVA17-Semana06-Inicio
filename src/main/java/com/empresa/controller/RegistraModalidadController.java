package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Deporte;
import com.empresa.entity.Modalidad;
import com.empresa.service.DeporteService;
import com.empresa.service.ModalidadService;

@Controller
public class RegistraModalidadController {

	@Autowired
	private DeporteService deporteService;

	@Autowired
	private ModalidadService modalidadService;

	@GetMapping(value = "/verRegistraModalidad")
	public String verAlumno() {
		return "registraModalidad";
	}

	@GetMapping(value = "/listaDeporte")
	@ResponseBody
	public List<Deporte> cargaDeporte() {
		return deporteService.listarTodos();
	}

	@PostMapping("/registraModalidad")
	@ResponseBody
	public Map<?, ?> registra(Modalidad obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		Modalidad objSalida = modalidadService.insertaModalidad(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		} else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}

	
	@GetMapping("/buscaPorNombre")
	@ResponseBody
	public String validaDni(String nombre) {
		List<Modalidad> lstModalidad = modalidadService.listaPorNombre(nombre);
		if (CollectionUtils.isEmpty(lstModalidad)) {
			return "{\"valid\" : true }";
		} else {
			return "{\"valid\" : false }";
		}
	}
}
