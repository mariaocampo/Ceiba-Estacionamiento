package co.com.ceiba.estacionamiento;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.controller.VehiculoController;
import co.com.ceiba.estacionamiento.entity.Vehiculo;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.VehiculoTestDataBuilder;

@RunWith(MockitoJUnitRunner.class)
public class VehiculoServiceTest {

	@Mock
	VehiculoController vehiculoController;
	
	@Test
	public void debeGuardarUnNuevoVehiculo() {
		//Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_CARRO).build();

		//Act
		Long result = vehiculoController.ingresarVehiculo(vehiculo);
		
		//Assert
		Assert.assertEquals(result, vehiculo.getId());
	}
}
