package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.model.Producto;
import com.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/Administrador")
public class AdministradorController {
	@Autowired
	private ProductoService productoservice;

	@GetMapping("")
	public String Home(Model model) {
		
		List<Producto> productos=productoservice.findAll();
		model.addAttribute("productos",productos);
		return "Administrador/Home";
	}
}
