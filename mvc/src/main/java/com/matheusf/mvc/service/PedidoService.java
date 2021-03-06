package com.matheusf.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

	public List<Pedido> findByStatus(StatusPedido aguardando, Pageable pageable) {
		return pedidoRepository.findByStatus(aguardando, pageable);
	}

	public List<Pedido> findByStatusAndUsuario(String username, StatusPedido status) {
		return pedidoRepository.findByStatusAndUsuario(username, status);
	}

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}	
}
