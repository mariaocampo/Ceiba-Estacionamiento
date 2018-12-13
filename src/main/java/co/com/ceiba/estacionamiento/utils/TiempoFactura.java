package co.com.ceiba.estacionamiento.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TiempoFactura {

	public long dias;
	public long horas;
	public long minutos;
	public long segundos;
	
	public TiempoFactura() {	}	
	
	public TiempoFactura(long dias, long horas, long minutos, long segundos) {
		super();
		this.dias = dias;
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public void calcularTiempoFactura(Date fechaIngreso, Date fechaSalida) {
		
		long periodo = fechaSalida.getTime() - fechaIngreso.getTime();;
		
		long formatoSegundos = 1000;
		long formatoMinutos = formatoSegundos * 60;
		long formatoHoras = formatoMinutos * 60;
		long formatoDias = formatoHoras * 24;

		this.dias = periodo / formatoDias;
		periodo = periodo % formatoDias;
		
		this.horas = periodo / formatoHoras;
		periodo = periodo % formatoHoras;
		
		this.minutos = periodo / formatoMinutos;
		periodo = periodo % formatoMinutos;
		
		this.segundos = periodo / formatoSegundos;
		
		redondearTiempo();
	}

	private void redondearTiempo() {
		this.minutos += (this.segundos > 0 ? 1 : 0);
		this.horas += (this.minutos > 0 ? 1 : 0);
	}

}
