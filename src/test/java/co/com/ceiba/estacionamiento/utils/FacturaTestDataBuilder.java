package co.com.ceiba.estacionamiento.utils;

import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;

public class FacturaTestDataBuilder {

	private Long id;
	private String placa;
	private String tipo;
	private double cilindraje;
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaIngreso;
	private double precio;
	
	public FacturaTestDataBuilder() {
		this.id = new Long(0);
		this.placa = Constantes.PLACA_VEHICULO_CARRO;
		this.tipo = Constantes.TIPO_VEHICULO_CARRO;
		this.cilindraje = 0.0;
		this.fechaIngreso = LocalDateTime.now();
		this.fechaSalida = null;
		this.precio = 0.0;
	}
	
	public FacturaTestDataBuilder porPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public FacturaTestDataBuilder porTipo(String tipo, String placa) {
		this.tipo = tipo;
		this.placa = placa;
		return this;
	}
	
	public FacturaTestDataBuilder porCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
		this.tipo = Constantes.TIPO_VEHICULO_MOTO;
		return this;
	}
	
	public FacturaTestDataBuilder porPlacayFecha(String placa, LocalDateTime fecha) {
		this.placa = placa;
		this.fechaIngreso = fecha;
		return this;
	}
		
	public FacturaDTO build() {
		return new FacturaDTO(id, tipo, placa, cilindraje, fechaIngreso, fechaSalida, precio);
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
