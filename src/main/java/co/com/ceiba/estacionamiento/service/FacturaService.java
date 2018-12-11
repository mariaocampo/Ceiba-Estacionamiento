package co.com.ceiba.estacionamiento.service;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;

public interface FacturaService {

	public String registrarFactura(FacturaDTO factura);
	
	public int consultarCantidadVehiculosPorTipo(String tipoVehiculo);
	
}
