package co.com.ceiba.estacionamiento.dto;

import java.time.LocalDateTime;

public class FacturaDTO {

	private Long id;
	private String tipoVehiculo;
	private String placa;
	private double cilindraje;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private double precio;
	
	public Long getId() {
		return id;
	}
	
	public FacturaDTO(Long id, String tipoVehiculo, String placa, double cilindraje, LocalDateTime fechaIngreso,
			LocalDateTime fechaSalida, double precio) {
		super();
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.precio = precio;
	}

	public FacturaDTO() {
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public double getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
