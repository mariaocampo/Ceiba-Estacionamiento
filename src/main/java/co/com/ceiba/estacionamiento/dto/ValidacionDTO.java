package co.com.ceiba.estacionamiento.dto;

import co.com.ceiba.estacionamiento.entity.Factura;

public class ValidacionDTO {

	private int cantidadMotos;
	private int cantidadCarros;
	private Factura factura;
	
	public ValidacionDTO() {	}

	public ValidacionDTO(int cantidadMotos, int cantidadCarros, Factura factura) {
		super();
		this.cantidadMotos = cantidadMotos;
		this.cantidadCarros = cantidadCarros;
		this.factura = factura;
	}

	public int getCantidadMotos() {
		return cantidadMotos;
	}
	public void setCantidadMotos(int cantidadMotos) {
		this.cantidadMotos = cantidadMotos;
	}
	public int getCantidadCarros() {
		return cantidadCarros;
	}
	public void setCantidadCarros(int cantidadCarros) {
		this.cantidadCarros = cantidadCarros;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
}
