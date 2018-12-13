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
import co.com.ceiba.estacionamiento.validacion.CobroTipoMoto;

@RunWith(MockitoJUnitRunner.class)
public class CobroVehiculoTest {
	
	@InjectMocks
	CobroTipoCarro cobroTipoCarro;
	
	@InjectMocks
	CobroTipoMoto cobroTipoMoto;
	
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
	
	@Test
	public void debeCalcularCobroCarroPorHoras() {
		FacturaDTO facturaDto = new FacturaTestDataBuilder().build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		TiempoFactura tiempo = Constantes.TIEMPO_FACTURA_TEST;
		tiempo.horas = 7;
		
		cobroTipoCarro.cobro(tiempo, factura);
		
		Assert.assertEquals(95000, factura.getPrecio(), 95000);
	}
	
	@Test
	public void debeCalcularCobroMotoPor11dias2Horas() {
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_MOTO).build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		cobroTipoMoto.cobro(Constantes.TIEMPO_FACTURA_TEST, factura);
		
		Assert.assertEquals(48000, factura.getPrecio(), 48000);
	}
	
	@Test
	public void debeCalcularCobroMotoPor12dias() {
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_MOTO).build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		TiempoFactura tiempo = Constantes.TIEMPO_FACTURA_TEST;
		tiempo.horas = 10;
		
		cobroTipoMoto.cobro(tiempo, factura);
		
		Assert.assertEquals(48000, factura.getPrecio(), 48000);
	}
	
	@Test
	public void debeCalcularCobroMotoPorHoras() {
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_MOTO).build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		TiempoFactura tiempo = Constantes.TIEMPO_FACTURA_TEST;
		tiempo.horas = 7;
		
		cobroTipoMoto.cobro(tiempo, factura);
		
		Assert.assertEquals(47500, factura.getPrecio(), 47500);
	}
	
	@Test
	public void debeCalcularCobroExcedenteCilindraje() {
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porCilindraje(Constantes.CILINDRAJE_TEST).build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		cobroTipoMoto.cobro(Constantes.TIEMPO_FACTURA_TEST, factura);
		
		Assert.assertEquals(49500, factura.getPrecio(), 49500);
	}
}
