package co.com.ceiba.estacionamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.entity.Vehiculo;
import co.com.ceiba.estacionamiento.service.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	@Autowired
	@Qualifier("vehiculoService")
	VehiculoService vehiculoService;
	
	@PostMapping("/ingresar_vehiculos")
	public String ingresarVehiculo(@RequestBody Vehiculo vehiculo){
		vehiculoService.registrarVehiculo(vehiculo);
		return vehiculo.getPlaca();
	}
}
