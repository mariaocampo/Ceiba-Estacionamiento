package co.com.ceiba.estacionamiento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;
import co.com.ceiba.estacionamiento.repository.VehiculoRepository;
import co.com.ceiba.estacionamiento.service.FacturaService;

@Service("facturaService")
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	@Qualifier("facturaRepository")
	FacturaRepository facturaRepository;
	
	@Autowired
	@Qualifier("vehiculoRepository")
	VehiculoRepository vehiculoRepository;
	
	@Override
	public String registrarFactura(Factura factura) {
		vehiculoRepository.save(factura.getVehiculo());
		return facturaRepository.save(factura).getId().toString();
	}

}
