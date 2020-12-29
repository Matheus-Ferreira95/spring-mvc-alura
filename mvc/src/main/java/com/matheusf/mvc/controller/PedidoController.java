package com.matheusf.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matheusf.mvc.dto.InsertPedidoDTO;
import com.matheusf.mvc.model.Pedido;
import com.matheusf.mvc.service.PedidoService;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/formulario")
	public ModelAndView formulario(InsertPedidoDTO pedidoDTO) {
		ModelAndView mv = new ModelAndView("pedido/formulario");
		return mv;
	}
	
	@GetMapping(value = "/novo")
	public ModelAndView getFormulario(InsertPedidoDTO pedidoDTO) {
		ModelAndView mv = new ModelAndView("pedido/formulario");
		return mv;
	}
	
	@PostMapping(value = "/novo")
	public ModelAndView novo(@Valid InsertPedidoDTO pedidoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("pedido/formulario");
		}
		
		Pedido pedido = pedidoDTO.toPedido();
		pedidoService.insert(pedido);
		
		return new ModelAndView("pedido/formulario");
	}
	
}
