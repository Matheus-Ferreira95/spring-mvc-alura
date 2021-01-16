package com.matheusf.mvc.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.mvc.model.Pedido;
import com.matheusf.mvc.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Cacheable("books")
	@Transactional(readOnly = true)
	List<Pedido> findByStatus(StatusPedido status, Pageable pageable);

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Pedido obj where obj.user.username = :username")
	List<Pedido> findAllByUsuario(String username);

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Pedido obj where obj.user.username = :username AND obj.status =:status")
	List<Pedido> findByStatusAndUsuario(String username, StatusPedido status);	
}
