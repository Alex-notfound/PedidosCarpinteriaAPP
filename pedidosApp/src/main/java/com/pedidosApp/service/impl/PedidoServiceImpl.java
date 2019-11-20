package com.pedidosApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.pedidosApp.commons.GenericServiceImpl;
import com.pedidosApp.entity.Pedido;
import com.pedidosApp.repository.PedidoRepository;
import com.pedidosApp.service.PedidoService;

@SuppressWarnings("serial")
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public CrudRepository<Pedido, Long> getDao() {
		return pedidoRepository;
	}

}
