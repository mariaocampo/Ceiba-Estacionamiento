package co.com.ceiba.estacionamiento.validacionesTest;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.TiempoFactura;

@RunWith(MockitoJUnitRunner.class)
public class TiempoVehiculoTest {

	@InjectMocks
	TiempoFactura tiempoFactura;
	
	@Test
	public void debeCalcularTiempoDeCobro() {
		//Arrange
		
		//Act
		tiempoFactura.calcularTiempoFactura(Timestamp.valueOf(Constantes.FECHA_INGRESO_TEST), Timestamp.valueOf(Constantes.FECHA_SALIDA_TEST));
		
		//Assert
		Assert.assertEquals(11, tiempoFactura.dias);
		Assert.assertEquals(3, tiempoFactura.horas);
		Assert.assertEquals(10, tiempoFactura.minutos);
		Assert.assertEquals(0, tiempoFactura.segundos);
	}
	
	@Test
	public void debeCalcularTiempoDeCobroConSegundos() {
		//Arrange

		//Act
		tiempoFactura.calcularTiempoFactura(Timestamp.valueOf(Constantes.FECHA_INGRESO_TEST), Timestamp.valueOf(Constantes.FECHA_SALIDA_TEST_SEGUNDOS));
		
		//Assert
		Assert.assertEquals(12, tiempoFactura.dias);
		Assert.assertEquals(3, tiempoFactura.horas);
		Assert.assertEquals(41, tiempoFactura.minutos);
		Assert.assertEquals(1, tiempoFactura.segundos);
		
	}
	
	@Test
	public void debeCalcularTiempoDeCobroConMinutos() {
		//Arrange

		//Act
		tiempoFactura.calcularTiempoFactura(Timestamp.valueOf(Constantes.FECHA_INGRESO_TEST), Timestamp.valueOf(Constantes.FECHA_SALIDA_TEST_MINUTOS));
		
		//Assert
		Assert.assertEquals(11, tiempoFactura.dias);
		Assert.assertEquals(1, tiempoFactura.horas);
		Assert.assertEquals(1, tiempoFactura.minutos);
		Assert.assertEquals(10, tiempoFactura.segundos);
		
	}
}
