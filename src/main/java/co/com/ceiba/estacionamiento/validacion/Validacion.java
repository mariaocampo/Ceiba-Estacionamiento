package co.com.ceiba.estacionamiento.validacion;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;

public interface Validacion {
	public void validar(FacturaDTO facturaDTO, FacturaRepository facturaRepository);
}
