package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;

@Controller
public class CrudModalidadController {

	@Autowired
	private ModalidadService modalidadService;
	
	@RequestMapping("/verCrudModalidad")
	public String verInicio() {
		return "crudModalidad";
	}
	
	@PostMapping("/registraCrudModalidad")
	@ResponseBody
	public Map<?, ?> registra(Modalidad obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Modalidad objSalida = modalidadService.insertaModalidad(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			List<Modalidad> lista = modalidadService.listaPorNombreLike("%");
			map.put("lista", lista);
			map.put("mensaje", "Registro exitoso");
		}
		return map;
	}
	
	@PostMapping("/actualizaCrudModalidad")
	@ResponseBody
	public Map<?, ?> actualiza(Modalidad obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Modalidad objSalida = modalidadService.actualizaModalidad(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Modalidad> lista = modalidadService.listaPorNombreLike("%");
			map.put("lista", lista);
			map.put("mensaje", "Actualización exitosa");
		}
		return map;
	}
	
	@PostMapping("/eliminaCrudModalidad")
	public Map<?, ?> elimina(Modalidad obj) {
		HashMap<String, String> map = new HashMap<String, String>();
	
		return map;
	}
	
	@GetMapping("/consultaCrudModalidad")
	@ResponseBody
	public List<Modalidad> consulta(String filtro) {
		return modalidadService.listaPorNombreLike("%"+filtro+"%");
	}
	
	
	
}