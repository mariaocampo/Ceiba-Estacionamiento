package co.com.ceiba.estacionamiento.validacion;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.TiempoFactura;

@Component
public class CobroTipoCarro implements CobroVehiculo {

	@Override
	public void cobro(TiempoFactura tiempoFactura, Factura factura) {	
		double precio = Constantes.PRECIO_REGISTRO_FACTURA;
		
		precio += Constantes.PRECIO_DIA_CARRO * tiempoFactura.dias;
		precio += (tiempoFactura.horas >= Constantes.LIMITE_HORAS_COBRO_DIA ? Constantes.PRECIO_DIA_CARRO : Constantes.PRECIO_HORA_CARRO * tiempoFactura.horas);

		factura.setPrecio(precio);
	}

}
