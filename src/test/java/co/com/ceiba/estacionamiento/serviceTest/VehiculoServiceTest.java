package co.com.ceiba.estacionamiento.serviceTest;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.entity.Vehiculo;
import co.com.ceiba.estacionamiento.repository.VehiculoRepository;
import co.com.ceiba.estacionamiento.service.impl.VehiculoServiceImpl;
import co.com.ceiba.estacionamiento.utils.MapeoDTO;

@RunWith(MockitoJUnitRunner.class)
public class VehiculoServiceTest {

	@InjectMocks
	VehiculoServiceImpl vehiculoService = new VehiculoServiceImpl();
	
	@Mock
	VehiculoRepository vehiculoRepository;
	
	MapeoDTO mapeoDTO = new MapeoDTO();
	
	@Test
	public void debeGuardarUnNuevoVehiculo() {
		//Arrange
		when(vehiculoRepository.save(Mockito.any(Vehiculo.class))).thenReturn(new Vehiculo());
		
		//act
		vehiculoService.registrarVehiculo(new Vehiculo());

	}
}
