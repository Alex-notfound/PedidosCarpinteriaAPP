package com.pedidosApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pedidosApp.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = { "", "/" })
	public String listAll(Model model) {
		model.addAttribute("list", pedidoService.getAll());
		return "PedidosList";
	}

	@GetMapping("/detail/{id}")
	public String detail(Model model) {
		// TODO: detail
		return "PedidoDetail";
	}

	@GetMapping("/edit/")
	public String edit(Model model) {
		// TODO: edit
		return "PedidoForm";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		pedidoService.delete(id);
		return listAll(model);
	}
}
