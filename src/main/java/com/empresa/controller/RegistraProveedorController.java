package com.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistraProveedorController {

	
	@GetMapping(value = "/verRegistraProveedor" )
	public String verProveedor() {return "registraProveedor";}

	
	
	
	

}
