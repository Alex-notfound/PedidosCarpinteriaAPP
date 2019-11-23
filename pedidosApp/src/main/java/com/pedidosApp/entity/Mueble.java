package com.pedidosApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mueble {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// TODO: Unidades?
	@Column
	private String tipo;
	@Column
	private String modelo;
	@Column
	private String color;
	@Column
	private String grosor;
	@Column
	private String medidas;
	@Column
	private String descripcion;
//TODO: Preguntar si meter precio
	@Column
	private double precio;
}
