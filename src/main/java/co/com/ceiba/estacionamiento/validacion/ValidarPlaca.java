package co.com.ceiba.estacionamiento.validacion;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.exception.EstacionamientoException;
import co.com.ceiba.estacionamiento.utils.Constantes;

@Component
public class ValidarPlaca implements Validacion {

	@Override
	public void validar(FacturaDTO facturaDTO) {
		for (String placaInvalida: Constantes.PLACA_INVALIDA) {
			
			boolean esLunes = facturaDTO.getFechaIngreso().getDayOfWeek().equals(DayOfWeek.MONDAY);
			boolean esDomingo = facturaDTO.getFechaIngreso().getDayOfWeek().equals(DayOfWeek.SUNDAY);
			
			if(!( esLunes || esDomingo )) {
				if(facturaDTO.getPlaca().toUpperCase().startsWith(placaInvalida)) {
					throw new EstacionamientoException(Constantes.PLACA_INVALIDA_EXCEPTION);
				}
			}
		}		
	}

}
