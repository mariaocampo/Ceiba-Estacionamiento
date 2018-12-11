package co.com.ceiba.estacionamiento;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.controller.FacturaController;
import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;
import co.com.ceiba.estacionamiento.repository.VehiculoRepository;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.FacturaTestDataBuilder;
import co.com.ceiba.estacionamiento.validacion.ValidarCantidadVehiculos;
import co.com.ceiba.estacionamiento.validacion.ValidarPlaca;
import co.com.ceiba.estacionamiento.validacion.ValidarTipoVehiculo;

@RunWith(MockitoJUnitRunner.class)
public class FacturaTest {

	
	@InjectMocks
	FacturaController facturaController;

	@Mock
	FacturaRepository facturaRepository;
	
	@Mock
	VehiculoRepository vehiculoRepository;
	
	@Mock
	ValidarPlaca validarPlaca;
	
	@Mock
	ValidarCantidadVehiculos validarCantidadVehiculos;
	
	@Mock
	ValidarTipoVehiculo validarTipoVehiculo;
	
	@Test
	public void debeGenerarUnaNuevaFactura() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_CARRO).build();
		
		//when(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(producto.getCodigo())).thenReturn(producto);
		when(facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.CAPACIDAD_CARROS_MENOR);
		when(facturaRepository.save(Mockito.any(Factura.class))).thenReturn(new Factura());
		
		//Act
		String result = facturaController.registrarFactura(facturaDto);
		
		//Assert
		Assert.assertEquals(result, facturaDto.getId());
	}
	
	@Test
	public void debeArrojarExcepcionPorTipoVehiculo() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_INVALIDO).build();
		
		try {
			// Act 
			String result = facturaController.registrarFactura(facturaDto);
			
			//Assert
			Assert.assertEquals(result, facturaDto.getId());
		}
		catch (Exception e) {
		    assertTrue(e.getMessage().equals("No se permite este tipo de vehículo"));
		}
	}
}
