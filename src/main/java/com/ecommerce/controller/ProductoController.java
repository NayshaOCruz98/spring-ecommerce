package com.ecommerce.controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.model.Producto;
import com.ecommerce.model.Usuario;
import com.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private ProductoService productoservice;
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("Productos", productoservice.findAll());
		return "productos/show";
	}
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("Este es el objeto producto {}",producto);
		Usuario u=new Usuario(1,"","","","","","","");
		productoservice.save(producto);
		producto.setUsuario(u);
		return "redirect:/productos";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto=new Producto();
		Optional<Producto> optionalProducto=productoservice.get(id);
		producto=optionalProducto.get();
		LOGGER.info("Producto buscado: {}", producto);
		model.addAttribute("producto", producto);
		return "productos/edit";
	}
	@PostMapping("/update")
	public String update(Producto producto) {
		productoservice.update(producto);
		return "redirect:/productos";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productoservice.delete(id);
		return "redirect:/productos";
	}
	
}
