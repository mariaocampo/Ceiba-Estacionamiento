package co.com.ceiba.estacionamiento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="placa")
	private String placa;
	
	@Column(name="tipo")
	private String tipo;	
	
	@Column(name="cilindraje")
	private double cilindraje;
	
	public Vehiculo() {	}

	public Vehiculo(String placa, String tipo, double cilindraje) {
		super();
		this.placa = placa;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}
}
