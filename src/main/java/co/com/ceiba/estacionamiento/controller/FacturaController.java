package co.com.ceiba.estacionamiento.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.service.FacturaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	@Qualifier("facturaService")
	FacturaService facturaService;
	
	@RequestMapping("/registrar_factura")
	public String registrarFactura(@RequestBody FacturaDTO facturaDTO) {
		return facturaService.registrarFactura(facturaDTO);
	}
	
	@GetMapping("/consultar_cantidad_por_tipo")
	public int consultarCantidad(@RequestBody String tipo) {
		return facturaService.consultarCantidadVehiculosPorTipo(tipo);
	}
	
	@RequestMapping("/retirar_vehiculo")
	public FacturaDTO retirarVehiculo(@RequestBody String placa) {
		return facturaService.retirarVehiculo(placa);
	}
	
	@GetMapping("/consultar_vehiculos_en_parqueadero")
	public List<FacturaDTO> consultarFacturasActivas(){
		return facturaService.consultarFacturasActivas();
	}
}
