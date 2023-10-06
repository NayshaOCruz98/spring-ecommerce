package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//crear un objeto en el cual instanciaremos el productoservice
	@Autowired //esto es para inyectar al contenedor del frameword la instancia de una clase
	private ProductoService productoservice;
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos",productoservice.findAll());
		return "usuario/home";
	}
}
