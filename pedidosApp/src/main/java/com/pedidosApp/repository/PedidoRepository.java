package com.pedidosApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidosApp.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
