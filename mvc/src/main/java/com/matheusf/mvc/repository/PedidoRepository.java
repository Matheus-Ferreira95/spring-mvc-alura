package com.matheusf.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheusf.mvc.model.Pedido;
import com.matheusf.mvc.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido aguardando);

	@Query("SELECT obj FROM Pedido obj where obj.user.username = :username")
	List<Pedido> findAllByUsuario(String username);
}
