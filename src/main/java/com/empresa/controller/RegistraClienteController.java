package com.empresa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Categoria;
import com.empresa.entity.Cliente;
import com.empresa.service.CategoriaService;
import com.empresa.service.ClienteService;

@Controller
public class RegistraClienteController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/verRegistraCliente" )
	public String verCliente() {return "registraCliente";}
	
	@GetMapping(value = "/listaCategoria")
	@ResponseBody
	public List<Categoria> cargaCategoria(){
		return categoriaService.listarTodo();
	}
	
	@PostMapping("/registraCliente")
	@ResponseBody
	public Map<?, ?> registra(Cliente obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		obj.setFechaRegistro(new Date());
		obj.setEstado(1);
		Cliente objSalida = clienteService.insertaCliente(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		} else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	@GetMapping("/buscaPorDni")
	@ResponseBody
	public String validaDni(String dni) {
		List<Cliente> lstCliente = clienteService.listaPorDni(dni);
		if(CollectionUtils.isEmpty(lstCliente)) {
			return "{\"valid\":true}";
		}else {
			return "{\"valid\":false}";
		}
	}
	
	@GetMapping("/buscaPorNombreCliente")
	@ResponseBody
	public String validaNombre(String nombre) {
		List<Cliente> lstCliente = clienteService.listaPorNombre(nombre);
		if(CollectionUtils.isEmpty(lstCliente)) {
			return "{\"valid\":true}";
		}else {
			return "{\"valid\":false}";
		}
	}
}
