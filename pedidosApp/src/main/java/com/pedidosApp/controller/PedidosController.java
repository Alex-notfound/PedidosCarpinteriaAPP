package com.pedidosApp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pedidosApp.model.Mueble;
import com.pedidosApp.model.Pedido;
import com.pedidosApp.service.MuebleService;
import com.pedidosApp.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private MuebleService muebleService;
	private Mueble muebleNuevo;

	public static String rutaFicheros = "datosPedidos/";

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

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("pedido", pedidoService.get(id));
		} else {
			model.addAttribute("pedido", new Pedido());
		}
		this.muebleNuevo = new Mueble();
		model.addAttribute("muebleNuevo", this.muebleNuevo);
		return "PedidoForm";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		pedidoService.delete(id);
		return listAll(model);
	}

	@PostMapping("/save")
	public String save(Pedido pedido, @RequestParam("files") MultipartFile[] files, Model model) {
		new File(rutaFicheros + pedido.getId().toString()).mkdir();
		int numFiles = new File(rutaFicheros + pedido.getId().toString()).listFiles().length;

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(rutaFicheros + pedido.getId().toString(), "file"  + ++numFiles + fileName.substring(fileName.lastIndexOf(".")));
			fileNames.append(file.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		pedidoService.save(pedido);
		return listAll(model);
	}

	@RequestMapping(value = "/save", params = { "addMueble" })
	public String addMueble(Pedido pedido, @RequestParam("unidades") String unidades, @RequestParam("tipo") String tipo,
			@RequestParam("modelo") String modelo, @RequestParam("color") String color,
			@RequestParam("grosor") String grosor, @RequestParam("medidas") String medidas,
			@RequestParam("descripcion") String descripcion, @RequestParam("precioUnitario") String precioUnitario) {

		Mueble mueble = new Mueble(unidades, tipo, modelo, color, grosor, medidas, descripcion, precioUnitario, pedido);
		muebleService.save(mueble);
		return "redirect:/pedidos/edit/" + pedido.getId();

	}

	@RequestMapping(value = "/save", params = { "removeMueble" })
	public String removeMueble(final Pedido pedido, final BindingResult bindingResult, final HttpServletRequest req) {
		muebleService.delete(Long.valueOf(req.getParameter("removeMueble")));
		return "redirect:/pedidos/edit/" + pedido.getId();
	}
}
