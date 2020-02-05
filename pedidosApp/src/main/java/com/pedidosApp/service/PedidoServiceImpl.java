package com.pedidosApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.pedidosApp.model.Pedido;
import com.pedidosApp.repository.PedidoRepository;

@SuppressWarnings("serial")
@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public CrudRepository<Pedido, Long> getDao() {
		return pedidoRepository;
	}

}
