package co.com.ceiba.estacionamiento.utils;

public class Constantes {

	//Tipos vehículos
	public static final String TIPO_VEHICULO_CARRO = "CARRO";
	public static final String TIPO_VEHICULO_MOTO = "MOTO";

	public static final String PLACA_VEHICULO_CARRO = "MAO123";
	
	//Reglas de validaciones
	public static final String[] PLACA_INVALIDA = {"A"};
	public static final int CANTIDAD_MAXIMA_CARROS = 20;
	public static final int CANTIDAD_MAXIMA_MOTOS = 10;
	
	
	//Excepciones
	public static final String PLACA_INVALIDA_EXCEPTION = "No tiene permisos para ingresar este día";
	public static final String CAPACIDAD_MAXIMA_CARROS_EXCEPTION = "No hay suficientes espacios para carros disponibles";
	public static final String CAPACIDAD_MAXIMA_MOTOS_EXCEPTION = "No hay suficientes espacios para motos disponibles";

}
