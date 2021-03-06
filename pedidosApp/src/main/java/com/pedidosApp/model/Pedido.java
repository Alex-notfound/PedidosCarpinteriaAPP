package com.pedidosApp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pedido_id")
	private Long id;
	@Column
	private String referencia;
	@Column
	private Date fechaPedido;
	@Column
	private Date fechaEntrega;
	@Column
	private double precio;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Mueble> muebles = new ArrayList<>();
	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean esUrgente;

	public boolean isEsUrgente() {
		return esUrgente;
	}

	public void setEsUrgente(boolean esUrgente) {
		this.esUrgente = esUrgente;
	}

	public List<Mueble> getMuebles() {
		return muebles;
	}

	public void setMuebles(List<Mueble> muebles) {
		this.muebles = muebles;
	}

	// TODO: Averiguar... Posiblemente almacenar rutas de imagenes en otra tabla con
	// un mismo ID
//	@Column
//	private String imagenes;
	@Column
	private String observacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
