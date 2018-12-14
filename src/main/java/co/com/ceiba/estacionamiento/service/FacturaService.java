package co.com.ceiba.estacionamiento.service;

import java.util.List;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;

public interface FacturaService {

	public String registrarFactura(FacturaDTO factura);
	
	public int consultarCantidadVehiculosPorTipo(String tipoVehiculo);
	
	public FacturaDTO retirarVehiculo(String placa);

	public List<FacturaDTO> consultarFacturasActivas();
	
}
