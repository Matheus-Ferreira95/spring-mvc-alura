package com.matheusf.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.mvc.model.Pedido;
import com.matheusf.mvc.model.StatusPedido;
import com.matheusf.mvc.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional(readOnly = true)
	public List<Pedido> findAllByUsuario(String username){
		return pedidoRepository.findAllByUsuario(username);
	}
	
	@Transactional
	public void insert(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	public List<Pedido> findByStatus(StatusPedido aguardando) {
		return pedidoRepository.findByStatus(aguardando);
	}	
}
