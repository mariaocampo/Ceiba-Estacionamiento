package co.com.ceiba.estacionamiento.serviceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.estacionamiento.Constantes;
import co.com.ceiba.estacionamiento.domain.service.VehiculoService;
import co.com.ceiba.estacionamiento.persistence.entity.Vehiculo;

@SpringBootTest
public class VehiculoServiceTest {
	
	@Autowired
	VehiculoService vehiculoService;
	
	@Test
	public void debeIngresarNuevoVehiculo() {
		//arrange
		Vehiculo vehiculo = new Vehiculo(new Long(1), "rty1365", Constantes.VEHICULO_CARRO);
		
		//act
		//int result = vehiculoService.registrarVehiculo(vehiculo);
		
		//assert
	}
}
