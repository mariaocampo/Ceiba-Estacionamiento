package co.com.ceiba.estacionamiento.utils;

import java.time.LocalDateTime;

public class Constantes {
	
	public static final double PRECIO_REGISTRO_FACTURA = 0;

	//Tipos vehículos
	public static final String TIPO_VEHICULO_CARRO = "CARRO";
	public static final String TIPO_VEHICULO_MOTO = "MOTO";
	
	//Reglas de validaciones
	public static final String[] PLACA_INVALIDA = {"A"};
	public static final int CANTIDAD_MAXIMA_CARROS = 20;
	public static final int CANTIDAD_MAXIMA_MOTOS = 10;
	
	//Excepciones
	public static final String PLACA_INVALIDA_EXCEPTION = "No tiene permisos para ingresar este día";
	public static final String CAPACIDAD_MAXIMA_CARROS_EXCEPTION = "No hay suficientes espacios para carros disponibles";
	public static final String CAPACIDAD_MAXIMA_MOTOS_EXCEPTION = "No hay suficientes espacios para motos disponibles";
	public static final String VEHICULO_NO_PERMITIDO_EXCEPTION = "No se permite este tipo de vehículo";
	
	//Constantes para pruebas
	public static final String PLACA_VEHICULO_CARRO = "MAO123";
	public static final String TIPO_VEHICULO_INVALIDO = "BICICLETA";
	public static final int CAPACIDAD_CARROS_MENOR = 10;
	public static final int CAPACIDAD_MOTOS_MENOR = 9;
	public static final String PLACA_INICAL_A = "AOR123";
	public static final LocalDateTime FECHA_NO_PERMITIDA_PLACA_A = LocalDateTime.of(2018, 12, 12, 8, 28);
	public static final LocalDateTime FECHA_PERMITIDA_LUNES_PLACA_A = LocalDateTime.of(2018, 12, 17, 8, 28);
	public static final LocalDateTime FECHA_PERMITIDA_DOMINGO_PLACA_A = LocalDateTime.of(2018, 12, 16, 8, 28);

}
