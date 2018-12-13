package co.com.ceiba.estacionamiento.validacionesTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.FacturaTestDataBuilder;
import co.com.ceiba.estacionamiento.utils.MapeoDTO;
import co.com.ceiba.estacionamiento.utils.TiempoFactura;
import co.com.ceiba.estacionamiento.validacion.CobroTipoCarro;

@RunWith(MockitoJUnitRunner.class)
public class CobroVehiculoTest {
	
	@InjectMocks
	CobroTipoCarro cobroTipoCarro;
	
	MapeoDTO mapeoDTO = new MapeoDTO();

	@Test
	public void debeCalcularCobroCarroPor11dias2Horas() {
		FacturaDTO facturaDto = new FacturaTestDataBuilder().build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		cobroTipoCarro.cobro(Constantes.TIEMPO_FACTURA_TEST, factura);
		
		Assert.assertEquals(90000, factura.getPrecio(), 90000);
	}
	
	@Test
	public void debeCalcularCobroCarroPor12dias() {
		FacturaDTO facturaDto = new FacturaTestDataBuilder().build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		TiempoFactura tiempo = Constantes.TIEMPO_FACTURA_TEST;
		tiempo.horas = 10;
		
		cobroTipoCarro.cobro(tiempo, factura);
		
		Assert.assertEquals(96000, factura.getPrecio(), 96000);
	}
}
