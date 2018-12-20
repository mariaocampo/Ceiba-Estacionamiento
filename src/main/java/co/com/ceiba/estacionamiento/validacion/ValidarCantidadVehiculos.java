package co.com.ceiba.estacionamiento.validacion;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.dto.ValidacionDTO;
import co.com.ceiba.estacionamiento.exception.EstacionamientoException;
import co.com.ceiba.estacionamiento.utils.Constantes;

@Component
public class ValidarCantidadVehiculos implements Validacion {
	
	@Override
	public void validar(FacturaDTO facturaDTO, ValidacionDTO validacionDTO) {
		
		if(facturaDTO.getTipoVehiculo().equals(Constantes.TIPO_VEHICULO_CARRO) && 
				validacionDTO.getCantidadCarros() >= Constantes.CANTIDAD_MAXIMA_CARROS) {
			throw new EstacionamientoException(Constantes.CAPACIDAD_MAXIMA_CARROS_EXCEPTION);
		}
		
		if(facturaDTO.getTipoVehiculo().equals(Constantes.TIPO_VEHICULO_MOTO) && 
				validacionDTO.getCantidadMotos() >= Constantes.CANTIDAD_MAXIMA_MOTOS) {
			throw new EstacionamientoException(Constantes.CAPACIDAD_MAXIMA_MOTOS_EXCEPTION);
		}		
	}

	
}
