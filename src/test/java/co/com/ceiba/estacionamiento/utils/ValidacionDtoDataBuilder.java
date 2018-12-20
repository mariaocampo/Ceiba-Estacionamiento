package co.com.ceiba.estacionamiento.utils;

import co.com.ceiba.estacionamiento.dto.ValidacionDTO;
import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.entity.Vehiculo;

public class ValidacionDtoDataBuilder {
	
	private int cantidadMotos;
	private int cantidadCarros;
	private Factura factura;
	
	public ValidacionDtoDataBuilder() {
		this.cantidadMotos = Constantes.CAPACIDAD_MOTOS_MENOR;
		this.cantidadCarros = Constantes.CAPACIDAD_CARROS_MENOR;
		this.factura = null;
	}
	
	public ValidacionDTO build() {
		return new ValidacionDTO(cantidadMotos, cantidadCarros, factura);
	}
	
	public ValidacionDtoDataBuilder conFactura() {
		this.factura = new Factura(
					new Long(1), 
					new Vehiculo(Constantes.PLACA_VEHICULO_CARRO, Constantes.TIPO_VEHICULO_CARRO, 0), 
					Constantes.FECHA_INGRESO_TEST,
					null, 
					0
				);
		
		return this;
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
