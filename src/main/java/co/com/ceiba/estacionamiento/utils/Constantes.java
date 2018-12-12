package co.com.ceiba.estacionamiento.utils;

import java.time.LocalDateTime;
import java.util.Date;

public class Constantes {
	
	private Constantes() {	}
	
	public static final double PRECIO_REGISTRO_FACTURA = 0;

	//Tipos vehículos
	public static final String TIPO_VEHICULO_CARRO = "CARRO";
	public static final String TIPO_VEHICULO_MOTO = "MOTO";
	
	//Reglas de validaciones
	public static final String[] PLACA_INVALIDA = {"A"};
	public static final int CANTIDAD_MAXIMA_CARROS = 20;
	public static final int CANTIDAD_MAXIMA_MOTOS = 10;
	
	//Valores para cobro
	public static final double HORA_CARRO = 1000;
	public static final double HORA_MOTO = 500;
	public static final double DIA_CARRO = 8000;
	public static final double DIA_MOTO = 4000;
	public static final double EXCEDENTE_MOTO = 2000;
	public static final double LIMITE_CILINDRAJE = 500;
	public static final int LIMITE_HORAS_COBRO_DIA = 9;
	
	
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
	@SuppressWarnings("deprecation")
	public static final Date FECHA_INGRESO_TEST = new Date(2018, 11, 1, 8, 20);
	@SuppressWarnings("deprecation")
	public static final Date FECHA_SALIDA_TEST = new Date(2018, 11, 12, 10, 30);
	public static final TiempoFactura TIEMPO_FACTURA_TEST = new TiempoFactura(11, 2, 10, 0);

}
