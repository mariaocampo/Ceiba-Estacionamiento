package co.com.ceiba.estacionamiento.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.entity.Vehiculo;
import co.com.ceiba.estacionamiento.service.FacturaService;
import co.com.ceiba.estacionamiento.validacion.ValidacionesFactura;

@RestController
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	@Qualifier("facturaService")
	FacturaService facturaService;
	
	@PostMapping("/registrar_factura")
	public void registrarFactura(Vehiculo vehiculo) {

		ValidacionesFactura validacionesFactura = new ValidacionesFactura();

		LocalDateTime fechaIngreso = LocalDateTime.now();
		
		if(!(fechaIngreso.getDayOfWeek() == DayOfWeek.MONDAY || fechaIngreso.getDayOfWeek() == DayOfWeek.SUNDAY)) {
			validacionesFactura.validarDiasHabiles(vehiculo.getPlaca());
		}
		
		validacionesFactura.validarCantidadVehiculos(vehiculo);
		
		Factura factura = new Factura();
		factura.setFechaEntrada(fechaIngreso);
		factura.setVehiculo(vehiculo);
		
		facturaService.registrarFactura(factura);
	}
}
