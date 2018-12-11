package co.com.ceiba.estacionamiento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;
import co.com.ceiba.estacionamiento.repository.VehiculoRepository;
import co.com.ceiba.estacionamiento.service.FacturaService;
import co.com.ceiba.estacionamiento.utils.MapeoDTO;

@Service("facturaService")
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	@Qualifier("facturaRepository")
	FacturaRepository facturaRepository;
	
	@Autowired
	@Qualifier("vehiculoRepository")
	VehiculoRepository vehiculoRepository;
	
	MapeoDTO mapeoDTO = new MapeoDTO();
	
	@Override
	public String registrarFactura(FacturaDTO facturaDTO) {
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDTO);
		vehiculoRepository.save(factura.getVehiculo());
		return facturaRepository.save(factura).getId().toString();
	}

	@Override
	public int consultarCantidadVehiculosPorTipo(String tipoVehiculo) {
		return facturaRepository.consultarCantidadVehiculosPorTipo(tipoVehiculo);
	}

}
