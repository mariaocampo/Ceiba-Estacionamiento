package co.com.ceiba.estacionamiento.utils;

import java.text.ParseException;

import co.com.ceiba.estacionamiento.entity.Vehiculo;

public class VehiculoTestDataBuilder {

	private Long id;
	private String placa;
	private String tipo;
	private double cilindraje;
	
	public VehiculoTestDataBuilder() {
		this.id = new Long(0);
		this.placa = Constantes.PLACA_VEHICULO_CARRO;
		this.tipo = Constantes.TIPO_VEHICULO_CARRO;
		this.cilindraje = 0.0;
	}
	
	public VehiculoTestDataBuilder porPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder porTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public VehiculoTestDataBuilder porCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(id, placa, tipo, cilindraje);
	}
}
