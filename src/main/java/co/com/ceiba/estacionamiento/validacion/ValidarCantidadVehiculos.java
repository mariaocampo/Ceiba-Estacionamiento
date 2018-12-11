package co.com.ceiba.estacionamiento.validacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.exception.EstacionamientoException;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;
import co.com.ceiba.estacionamiento.utils.Constantes;

@Component
public class ValidarCantidadVehiculos implements Validacion {


	@Autowired
	@Qualifier("facturaRepository")
	FacturaRepository facturaRepository;
	
	@Override
	public void validar(FacturaDTO facturaDTO) {
		if(facturaDTO.getTipoVehiculo().equals(Constantes.TIPO_VEHICULO_CARRO) && 
				facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO) >= Constantes.CANTIDAD_MAXIMA_CARROS) {
			throw new EstacionamientoException(Constantes.CAPACIDAD_MAXIMA_CARROS_EXCEPTION);
		}
		
		if(facturaDTO.getTipoVehiculo().equals(Constantes.TIPO_VEHICULO_MOTO) && 
				facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_MOTO) >= Constantes.CANTIDAD_MAXIMA_MOTOS) {
			throw new EstacionamientoException(Constantes.CAPACIDAD_MAXIMA_CARROS_EXCEPTION);
		}		
	}

	
}
