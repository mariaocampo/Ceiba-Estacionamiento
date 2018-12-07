package co.com.ceiba.estacionamiento.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.domain.service.VehiculoService;
import co.com.ceiba.estacionamiento.persistence.entity.Vehiculo;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	@Autowired
	VehiculoService vehiculoService;
	
	@PostMapping("/ingresar_vehiculos")
	public Long ingresarVehiculo(@RequestBody Vehiculo vehiculo){
		vehiculoService.registrarVehiculo(vehiculo);
		return vehiculo.getId();
	}
}
