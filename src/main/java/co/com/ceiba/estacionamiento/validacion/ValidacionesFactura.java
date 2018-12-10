package co.com.ceiba.estacionamiento.validacion;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.entity.Vehiculo;
import co.com.ceiba.estacionamiento.exception.EstacionamientoException;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;
import co.com.ceiba.estacionamiento.utils.Constantes;

public class ValidacionesFactura {

	@Autowired
	FacturaRepository facturaRepository;
	
	public void validarDiasHabiles(String placa) {
		
		for (String placaInvalida: Constantes.PLACA_INVALIDA) {
			if(placa.startsWith(placaInvalida)) throw new EstacionamientoException(Constantes.PLACA_INVALIDA_EXCEPTION);
		}
	}
	
	public void validarCantidadVehiculos(Vehiculo vehiculo) {
		if(vehiculo.getTipo() == Constantes.TIPO_VEHICULO_CARRO && 
				facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO) >= Constantes.CANTIDAD_MAXIMA_CARROS) {
			throw new EstacionamientoException(Constantes.CAPACIDAD_MAXIMA_CARROS_EXCEPTION);
		}
		
		if(vehiculo.getTipo() == Constantes.TIPO_VEHICULO_MOTO && 
				facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_MOTO) >= Constantes.CANTIDAD_MAXIMA_MOTOS) {
			throw new EstacionamientoException(Constantes.CAPACIDAD_MAXIMA_CARROS_EXCEPTION);
		}
	}
}
