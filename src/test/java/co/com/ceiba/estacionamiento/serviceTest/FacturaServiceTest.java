package co.com.ceiba.estacionamiento.serviceTest;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.entity.Vehiculo;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;
import co.com.ceiba.estacionamiento.repository.VehiculoRepository;
import co.com.ceiba.estacionamiento.service.impl.FacturaServiceImpl;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.FacturaTestDataBuilder;
import co.com.ceiba.estacionamiento.utils.MapeoDTO;
import co.com.ceiba.estacionamiento.utils.TiempoFactura;
import co.com.ceiba.estacionamiento.validacion.CobroTipoCarro;
import co.com.ceiba.estacionamiento.validacion.CobroTipoMoto;
import co.com.ceiba.estacionamiento.validacion.ValidarCantidadVehiculos;
import co.com.ceiba.estacionamiento.validacion.ValidarPlaca;
import co.com.ceiba.estacionamiento.validacion.ValidarTipoVehiculo;

@RunWith(MockitoJUnitRunner.class)
public class FacturaServiceTest {
	
	@InjectMocks
	FacturaServiceImpl facturaService = new FacturaServiceImpl();

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
	
	@Mock
	TiempoFactura tiempoFactura;
	
	@Mock
	CobroTipoCarro cobroTipoCarro;
	
	@Mock
	CobroTipoMoto cobroTipoMoto;
	
	MapeoDTO mapeoDTO = new MapeoDTO();
	
	@Test
	public void debeGenerarUnaNuevaFactura() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_CARRO).build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);

		when(facturaRepository.save(Mockito.any(Factura.class))).thenReturn(factura);
		when(vehiculoRepository.save(Mockito.any(Vehiculo.class))).thenReturn(new Vehiculo());
		
		//Act
		String result = facturaService.registrarFactura(facturaDto);
		
		//Assert
		Assert.assertEquals(result, facturaDto.getId().toString());
	}
	
	@Test
	public void debeConsultarCantidadVehiculos() {
		//Arrange
		when(facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.CAPACIDAD_CARROS_MENOR);
	
		//Act
		int cantidad = facturaService.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO);
		
		//Assert
		Assert.assertEquals(cantidad, 10);
	}
	
	@Test
	public void debeRetirarVehiculoCarro() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		when(facturaRepository.consultarFacturaPorPlaca(Constantes.PLACA_VEHICULO_CARRO)).thenReturn(factura);
		tiempoFactura.dias = 10;
		tiempoFactura.horas = 2;
		
		FacturaDTO result = facturaService.retirarVehiculo(Constantes.PLACA_VEHICULO_CARRO);
		
		Assert.assertTrue(result.getFechaSalida() != null);
	}
	
	@Test
	public void debeRetirarVehiculoMoto() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_MOTO).build();
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDto);
		
		when(facturaRepository.consultarFacturaPorPlaca(Constantes.PLACA_VEHICULO_CARRO)).thenReturn(factura);
		tiempoFactura.dias = 10;
		tiempoFactura.horas = 2;
		
		FacturaDTO result = facturaService.retirarVehiculo(Constantes.PLACA_VEHICULO_CARRO);
		
		Assert.assertTrue(result.getFechaSalida() != null);
	}
}
