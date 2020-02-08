package com.pedidosApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.pedidosApp.model.Mueble;
import com.pedidosApp.repository.MuebleRepository;

@SuppressWarnings("serial")
@Service
public class MuebleServiceImpl extends GenericServiceImpl<Mueble, Long> implements MuebleService {

	@Autowired
	private MuebleRepository MuebleRepository;

	@Override
	public CrudRepository<Mueble, Long> getDao() {
		return MuebleRepository;
	}

}
