package com.pedidosApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidosApp.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
