package co.com.ceiba.estacionamiento.controllerTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.controller.VehiculoController;
import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.service.VehiculoService;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.FacturaTestDataBuilder;
import co.com.ceiba.estacionamiento.utils.MapeoDTO;

@RunWith(MockitoJUnitRunner.class)
public class VehiculoControllerTest {

	@InjectMocks
	VehiculoController vehiculoController;
	
	@Mock
	VehiculoService vehiculoService;
	
	MapeoDTO mapeoDTO = new MapeoDTO();

	@Test
	public void debeLlamarServicioParaRegistrarVehiculo() {
		//Arrange
		Factura factura = mapeoDTO.convertirFacturaDTO(new FacturaTestDataBuilder().build());
		
		//Act
		String result = vehiculoController.ingresarVehiculo(factura.getVehiculo());
		
		//Assert
		Assert.assertEquals(result, Constantes.PLACA_VEHICULO_CARRO);
	}
	
}
