package co.com.ceiba.estacionamiento.validacionesTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;
import co.com.ceiba.estacionamiento.repository.VehiculoRepository;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.FacturaTestDataBuilder;
import co.com.ceiba.estacionamiento.utils.MapeoDTO;
import co.com.ceiba.estacionamiento.validacion.ValidarCantidadVehiculos;
import co.com.ceiba.estacionamiento.validacion.ValidarPlaca;
import co.com.ceiba.estacionamiento.validacion.ValidarTipoVehiculo;

@RunWith(MockitoJUnitRunner.class)
public class ValidacionTest {
	
	@Mock
	VehiculoRepository vehiculoRepository;
	
	@Mock
	FacturaRepository facturaRepository;
	
	@InjectMocks
	ValidarPlaca validarPlaca;
	
	@InjectMocks
	ValidarCantidadVehiculos validarCantidadVehiculos;
	
	@InjectMocks
	ValidarTipoVehiculo validarTipoVehiculo;
	
	MapeoDTO mapeoDTO = new MapeoDTO();
	
	@Test
	public void debeArrojarExcepcionPorTipoVehiculo() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_INVALIDO,Constantes.PLACA_VEHICULO_MOTO).build();
		
		try {
			// Act 
			validarTipoVehiculo.validar(facturaDto, facturaRepository);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No se permite este tipo de veh�culo"));
		}
	}
	
	@Test
	public void debeValidarTipoVehiculoCarro() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_CARRO, Constantes.PLACA_VEHICULO_CARRO).build();
		
		try {
			// Act 
			validarTipoVehiculo.validar(facturaDto, facturaRepository);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No se permite este tipo de veh�culo"));
		}
	}
	
	@Test
	public void debeValidarTipoVehiculoMoto() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_MOTO,Constantes.PLACA_VEHICULO_MOTO).build();
		
		try {
			// Act 
			validarTipoVehiculo.validar(facturaDto, facturaRepository);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No se permite este tipo de veh�culo"));
		}
	}
	
	@Test
	public void debeArrojarExcepcionPorCantidadCarrosMaxima() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_CARRO, Constantes.PLACA_VEHICULO_CARRO).build();
		
		when(facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.CANTIDAD_MAXIMA_CARROS);

		try{
			// Act 
			validarCantidadVehiculos.validar(facturaDto, facturaRepository);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No hay suficientes espacios para carros disponibles"));
		}
	}
	
	@Test
	public void debeArrojarExcepcionPorCantidadMotosMaxima() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_MOTO, Constantes.PLACA_VEHICULO_MOTO).build();
		
		when(facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(Constantes.CANTIDAD_MAXIMA_MOTOS);

		try{
			// Act 
			validarCantidadVehiculos.validar(facturaDto, facturaRepository);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No hay suficientes espacios para motos disponibles"));
		}
	}
	
	@Test
	public void debeValidarCantidadCarrosMenor() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_CARRO, Constantes.PLACA_VEHICULO_CARRO).build();
		
		when(facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.CAPACIDAD_CARROS_MENOR);

		try{
			// Act 
			validarCantidadVehiculos.validar(facturaDto, facturaRepository);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No hay suficientes espacios para motos disponibles"));
		}
	}
	
	@Test
	public void debeValidarCantidadMotosMenor() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_MOTO, Constantes.PLACA_VEHICULO_MOTO).build();
		
		when(facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(Constantes.CAPACIDAD_MOTOS_MENOR);

		try{
			// Act 
			validarCantidadVehiculos.validar(facturaDto, facturaRepository);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No hay suficientes espacios para motos disponibles"));
		}
	}
	
	@Test
	public void debeArrojarExcepcionPorPlacaInvalida() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFecha(Constantes.PLACA_INICAL_A, Constantes.FECHA_NO_PERMITIDA_PLACA_A).build();

		try {
			//Act
			validarPlaca.validar(facturaDto,facturaRepository);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No tiene permisos para ingresar este d�a"));
		}	
	}
	
	@Test
	public void debeValidarLosDiasValidosDeLaPlacaLunes() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFecha(Constantes.PLACA_INICAL_A, Constantes.FECHA_PERMITIDA_LUNES_PLACA_A).build();

		try {
			//Act
			validarPlaca.validar(facturaDto, facturaRepository);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No tiene permisos para ingresar este d�a"));
		}	
	}
	
	@Test
	public void debeValidarLosDiasValidosDeLaPlacaDomingo() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFecha(Constantes.PLACA_INICAL_A, Constantes.FECHA_PERMITIDA_DOMINGO_PLACA_A).build();

		try {
			//Act
			validarPlaca.validar(facturaDto, facturaRepository);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No tiene permisos para ingresar este d�a"));
		}	
	}
	
	@Test
	public void debeValidarLosDiasyPlaca() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFecha(Constantes.PLACA_VEHICULO_CARRO, Constantes.FECHA_NO_PERMITIDA_PLACA_A).build();

		try {
			//Act
			validarPlaca.validar(facturaDto, facturaRepository);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No tiene permisos para ingresar este d�a"));
		}	
	}
	
	@Test
	public void debeValidarPlacaYaRegistrada() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFechaSalida(Constantes.PLACA_VEHICULO_CARRO, Constantes.FECHA_NO_PERMITIDA_PLACA_A).build();
		when(facturaRepository.consultarFacturaPorPlaca(Constantes.PLACA_VEHICULO_CARRO)).thenReturn(mapeoDTO.convertirFacturaDTO(facturaDto));

		try {
			//Act
			validarPlaca.validar(facturaDto, facturaRepository);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("Esta placa se encuentra activa en el parqueadero"));
		}	
	}
	
}
