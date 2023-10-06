package com.empresa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;

@Controller
public class ModalidadCrudController {

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
		obj.setEstado(1);
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());  
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
		  
		Optional<Modalidad> optModalidad= modalidadService.buscaModalidad(obj.getIdModalidad());
		obj.setFechaRegistro(optModalidad.get().getFechaRegistro());
		obj.setEstado(optModalidad.get().getEstado());
		obj.setFechaActualizacion(new Date());
		
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
	
	@ResponseBody
	@PostMapping("/eliminaCrudModalidad")
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Modalidad objModalidad= modalidadService.buscaModalidad(id).get();
		objModalidad.setFechaActualizacion(new Date());  
		objModalidad.setEstado( objModalidad.getEstado() == 1 ? 0 : 1);
		Modalidad objSalida = modalidadService.actualizaModalidad(objModalidad);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Modalidad> lista = modalidadService.listaPorNombreLike("%");
			map.put("lista", lista);
		}
		return map;
	}
	
	@GetMapping("/consultaCrudModalidad")
	@ResponseBody
	public List<Modalidad> consulta(String filtro) {
		return modalidadService.listaPorNombreLike("%"+filtro+"%");
	}
	
	
	
}