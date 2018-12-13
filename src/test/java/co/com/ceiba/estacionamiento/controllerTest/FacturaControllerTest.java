package co.com.ceiba.estacionamiento.controllerTest;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.controller.FacturaController;
import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.service.FacturaService;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.FacturaTestDataBuilder;

@RunWith(MockitoJUnitRunner.class)
public class FacturaControllerTest {

	@InjectMocks
	FacturaController facturaController;
	
	@Mock
	FacturaService facturaService;
	
	@Test
	public void debeLlamarServicioParaRegistrarFactura() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().build();
		when(facturaService.registrarFactura(facturaDto)).thenReturn(facturaDto.getId().toString());
		
		//Act
		String result = facturaController.registrarFactura(facturaDto);
		
		//Assert
		Assert.assertEquals(result, facturaDto.getId().toString());
	}
	
	@Test
	public void debeLlamarServicioParaConsultarCantidadVehiculos() {
		//Arrange
		when(facturaService.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.CANTIDAD_MAXIMA_CARROS);

		//Act
		int result = facturaController.consultarCantidad(Constantes.TIPO_VEHICULO_CARRO);
		
		//Assert
		Assert.assertEquals(result, 20);
	}
	
	@Test
	public void debeLlamarServicioParaRetirarVehiculo() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().build();
		
		when(facturaService.retirarVehiculo(Constantes.PLACA_VEHICULO_CARRO)).thenReturn(facturaDto);

		//Act
		FacturaDTO result = facturaController.retirarVehiculo(Constantes.PLACA_VEHICULO_CARRO);
		
		//Assert
		Assert.assertEquals(result, facturaDto);
	}
}
