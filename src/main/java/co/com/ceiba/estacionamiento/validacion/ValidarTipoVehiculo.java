package co.com.ceiba.estacionamiento.validacion;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.dto.ValidacionDTO;
import co.com.ceiba.estacionamiento.exception.EstacionamientoException;
import co.com.ceiba.estacionamiento.utils.Constantes;

@Component
public class ValidarTipoVehiculo implements Validacion {

	@Override
	public void validar(FacturaDTO facturaDTO, ValidacionDTO validacionDTO) {
		if(!(facturaDTO.getTipoVehiculo().equals(Constantes.TIPO_VEHICULO_CARRO) || facturaDTO.getTipoVehiculo().equals(Constantes.TIPO_VEHICULO_MOTO))) {
			throw new EstacionamientoException(Constantes.VEHICULO_NO_PERMITIDO_EXCEPTION);
		}		
	}

}
