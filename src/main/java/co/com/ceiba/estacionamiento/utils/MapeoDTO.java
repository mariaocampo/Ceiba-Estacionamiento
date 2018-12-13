package co.com.ceiba.estacionamiento.utils;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.entity.Vehiculo;

public class MapeoDTO {

	public Factura convertirFacturaDTO(FacturaDTO facturaDTO) {
		Factura factura = new Factura();
		factura.setId(facturaDTO.getId());
		factura.setFechaEntrada(facturaDTO.getFechaIngreso());
		factura.setFechaSalida(facturaDTO.getFechaSalida());
		factura.setPrecio(facturaDTO.getPrecio());
		factura.setVehiculo(new Vehiculo(facturaDTO.getPlaca(), facturaDTO.getTipoVehiculo(), facturaDTO.getCilindraje()));
		
		return factura;
	}
	
	public FacturaDTO convertirFacturaEntidad(Factura factura) {
		FacturaDTO facturaDto = new FacturaDTO(); 
		facturaDto.setId(factura.getId());
		facturaDto.setPrecio(factura.getPrecio());
		facturaDto.setCilindraje(factura.getVehiculo().getCilindraje());
		facturaDto.setFechaIngreso(factura.getFechaEntrada());
		facturaDto.setFechaSalida(factura.getFechaSalida());
		facturaDto.setPlaca(factura.getVehiculo().getPlaca());
		facturaDto.setTipoVehiculo(factura.getVehiculo().getTipo());
		
		return facturaDto;
	}
}
