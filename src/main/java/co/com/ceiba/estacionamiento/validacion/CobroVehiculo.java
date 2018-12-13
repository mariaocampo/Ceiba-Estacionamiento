package co.com.ceiba.estacionamiento.validacion;

import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.utils.TiempoFactura;

public interface CobroVehiculo {

	public void cobro(TiempoFactura tiempoFactura, Factura factura);
}
