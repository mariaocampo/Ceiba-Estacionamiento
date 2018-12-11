package co.com.ceiba.estacionamiento.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.service.FacturaService;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.validacion.Validacion;
import co.com.ceiba.estacionamiento.validacion.ValidarCantidadVehiculos;
import co.com.ceiba.estacionamiento.validacion.ValidarPlaca;
import co.com.ceiba.estacionamiento.validacion.ValidarTipoVehiculo;

@RestController
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	@Qualifier("facturaService")
	FacturaService facturaService;
	
	List<Validacion> validacionesFactura;
	
	@Autowired
	ValidarPlaca validarPlaca;
	
	@Autowired
	ValidarCantidadVehiculos validarCantidadVehiculos;
	
	@Autowired
	ValidarTipoVehiculo validarTipoVehiculo;
	
	@PostMapping("/registrar_factura")
	public String registrarFactura(@RequestBody FacturaDTO facturaDTO) {

		facturaDTO.setFechaIngreso(LocalDateTime.now());
		facturaDTO.setPrecio(Constantes.PRECIO_REGISTRO_FACTURA);
		
		validacionesFactura = new ArrayList<>();
		validacionesFactura.add(validarTipoVehiculo);
		validacionesFactura.add(validarPlaca);
		validacionesFactura.add(validarCantidadVehiculos);
		
		for(Validacion validacion: validacionesFactura) {
			validacion.validar(facturaDTO);
		}
		
		return facturaService.registrarFactura(facturaDTO);
	}
	
	@GetMapping("/consultar_cantidad_por_tipo")
	public int consultarCantidad(@RequestBody String tipo) {
		return facturaService.consultarCantidadVehiculosPorTipo(tipo);
	}
}
