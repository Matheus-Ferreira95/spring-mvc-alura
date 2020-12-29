package com.matheusf.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matheusf.mvc.model.Pedido;
import com.matheusf.mvc.model.StatusPedido;
import com.matheusf.mvc.service.PedidoService;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView("home");
		List<Pedido> pedidos = pedidoService.findAll();
		model.addAttribute("pedidos", pedidos);		
		return mv;
	}
	
	@GetMapping("/{status}")
	public ModelAndView porStatus(Model model, @PathVariable String status) {
		ModelAndView mv = new ModelAndView("home");
		List<Pedido> pedidos = pedidoService.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);		
		model.addAttribute("status", status);
		return mv;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
