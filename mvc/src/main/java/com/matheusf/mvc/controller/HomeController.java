
package com.matheusf.mvc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matheusf.mvc.model.Pedido;
import com.matheusf.mvc.model.StatusPedido;
import com.matheusf.mvc.service.PedidoService;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public String home(Model model, Principal principal) {
		List<Pedido> pedidos = pedidoService.findAllByUsuario(principal.getName());
		model.addAttribute("pedidos", pedidos);
		return "home"; 
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = pedidoService.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home"; 
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
