package co.com.ceiba.estacionamiento.validacionesTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.dto.ValidacionDTO;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.FacturaTestDataBuilder;
import co.com.ceiba.estacionamiento.utils.MapeoDTO;
import co.com.ceiba.estacionamiento.utils.ValidacionDtoDataBuilder;
import co.com.ceiba.estacionamiento.validacion.ValidarCantidadVehiculos;
import co.com.ceiba.estacionamiento.validacion.ValidarPlaca;
import co.com.ceiba.estacionamiento.validacion.ValidarTipoVehiculo;

@RunWith(MockitoJUnitRunner.class)
public class ValidacionTest {
	
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
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();
		
		try {
			// Act 
			validarTipoVehiculo.validar(facturaDto, validacion);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No se permite este tipo de vehículo"));
		}
	}
	
	@Test
	public void debeValidarTipoVehiculoCarro() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_CARRO, Constantes.PLACA_VEHICULO_CARRO).build();
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try {
			// Act 
			validarTipoVehiculo.validar(facturaDto, validacion);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No se permite este tipo de vehículo"));
		}
	}
	
	@Test
	public void debeValidarTipoVehiculoMoto() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_MOTO,Constantes.PLACA_VEHICULO_MOTO).build();
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try {
			// Act 
			validarTipoVehiculo.validar(facturaDto, validacion);	
		}
		catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No se permite este tipo de vehículo"));
		}
	}
	
	@Test
	public void debeArrojarExcepcionPorCantidadCarrosMaxima() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porTipo(Constantes.TIPO_VEHICULO_CARRO, Constantes.PLACA_VEHICULO_CARRO).build();
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try{
			// Act 
			validarCantidadVehiculos.validar(facturaDto, validacion);	
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
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try{
			// Act 
			validarCantidadVehiculos.validar(facturaDto, validacion);	
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
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try{
			// Act 
			validarCantidadVehiculos.validar(facturaDto, validacion);	
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
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try{
			// Act 
			validarCantidadVehiculos.validar(facturaDto, validacion);	
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
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try {
			//Act
			validarPlaca.validar(facturaDto,validacion);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No tiene permisos para ingresar este día"));
		}	
	}
	
	@Test
	public void debeValidarLosDiasValidosDeLaPlacaLunes() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFecha(Constantes.PLACA_INICAL_A, Constantes.FECHA_PERMITIDA_LUNES_PLACA_A).build();
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try {
			//Act
			validarPlaca.validar(facturaDto, validacion);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No tiene permisos para ingresar este día"));
		}	
	}
	
	@Test
	public void debeValidarLosDiasValidosDeLaPlacaDomingo() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFecha(Constantes.PLACA_INICAL_A, Constantes.FECHA_PERMITIDA_DOMINGO_PLACA_A).build();
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try {
			//Act
			validarPlaca.validar(facturaDto, validacion);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No tiene permisos para ingresar este día"));
		}	
	}
	
	@Test
	public void debeValidarLosDiasyPlaca() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFecha(Constantes.PLACA_VEHICULO_CARRO, Constantes.FECHA_NO_PERMITIDA_PLACA_A).build();
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().build();

		try {
			//Act
			validarPlaca.validar(facturaDto, validacion);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("No tiene permisos para ingresar este día"));
		}	
	}
	
	@Test
	public void debeValidarPlacaYaRegistrada() {
		//Arrange
		FacturaDTO facturaDto = new FacturaTestDataBuilder().porPlacayFechaSalida(Constantes.PLACA_VEHICULO_CARRO, Constantes.FECHA_NO_PERMITIDA_PLACA_A).build();
		ValidacionDTO validacion = new ValidacionDtoDataBuilder().conFactura().build();

		try {
			//Act
			validarPlaca.validar(facturaDto, validacion);
		} catch (Exception e) {
			//Assert
			assertTrue(e.getMessage().equals("Esta placa se encuentra activa en el parqueadero"));
		}	
	}
	
}
