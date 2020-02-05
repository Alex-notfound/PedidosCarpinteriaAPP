package com.pedidosApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pedidosApp.service.PedidoService;

@Controller
public class PedidosController {

	@Autowired
	private PedidoService perdidoService;

	@RequestMapping(value = { "", "/" })
	public String index(Model model) {
		model.addAttribute("list", perdidoService.getAll());
		return "PedidosList";
	}
}
