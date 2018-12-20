package co.com.ceiba.estacionamiento.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dto.FacturaDTO;
import co.com.ceiba.estacionamiento.dto.ValidacionDTO;
import co.com.ceiba.estacionamiento.entity.Factura;
import co.com.ceiba.estacionamiento.repository.FacturaRepository;
import co.com.ceiba.estacionamiento.repository.VehiculoRepository;
import co.com.ceiba.estacionamiento.service.FacturaService;
import co.com.ceiba.estacionamiento.utils.Constantes;
import co.com.ceiba.estacionamiento.utils.MapeoDTO;
import co.com.ceiba.estacionamiento.utils.TiempoFactura;
import co.com.ceiba.estacionamiento.validacion.CobroTipoCarro;
import co.com.ceiba.estacionamiento.validacion.CobroTipoMoto;
import co.com.ceiba.estacionamiento.validacion.Validacion;
import co.com.ceiba.estacionamiento.validacion.ValidarCantidadVehiculos;
import co.com.ceiba.estacionamiento.validacion.ValidarPlaca;
import co.com.ceiba.estacionamiento.validacion.ValidarTipoVehiculo;

@Service("facturaService")
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	@Qualifier("facturaRepository")
	FacturaRepository facturaRepository;
	
	@Autowired
	@Qualifier("vehiculoRepository")
	VehiculoRepository vehiculoRepository;
	
	@Autowired
	ValidarPlaca validarPlaca;
	
	@Autowired
	ValidarCantidadVehiculos validarCantidadVehiculos;
	
	@Autowired
	ValidarTipoVehiculo validarTipoVehiculo;
	
	@Autowired
	TiempoFactura tiempoFactura;
	
	@Autowired
	CobroTipoCarro cobroTipoCarro;
	
	@Autowired
	CobroTipoMoto cobroTipoMoto;
	
	List<Validacion> validacionesFactura;

	MapeoDTO mapeoDTO = new MapeoDTO();
	
	@Override
	public String registrarFactura(FacturaDTO facturaDTO) {
				
		facturaDTO.setFechaIngreso(LocalDateTime.now());
		facturaDTO.setPrecio(Constantes.PRECIO_REGISTRO_FACTURA);
		
		validacionesFactura = new ArrayList<>();
		validacionesFactura.add(validarTipoVehiculo);
		validacionesFactura.add(validarPlaca);
		validacionesFactura.add(validarCantidadVehiculos);
		
		ValidacionDTO validacionDTO = new ValidacionDTO();
		validacionDTO.setCantidadCarros(facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_CARRO));
		validacionDTO.setCantidadMotos(facturaRepository.consultarCantidadVehiculosPorTipo(Constantes.TIPO_VEHICULO_MOTO));
		validacionDTO.setFactura(facturaRepository.consultarFacturaPorPlaca(facturaDTO.getPlaca()));
		
		for(Validacion validacion: validacionesFactura) {
			validacion.validar(facturaDTO,validacionDTO);
		}
		
		Factura factura = mapeoDTO.convertirFacturaDTO(facturaDTO);
		vehiculoRepository.save(factura.getVehiculo());
		return facturaRepository.save(factura).getId().toString(); 
	}

	@Override
	public int consultarCantidadVehiculosPorTipo(String tipoVehiculo) {
		return facturaRepository.consultarCantidadVehiculosPorTipo(tipoVehiculo);
	}

	@Override
	public FacturaDTO retirarVehiculo(String placa) {
		Factura factura = facturaRepository.consultarFacturaPorPlaca(placa);
		factura.setFechaSalida(LocalDateTime.now());
		
		tiempoFactura.calcularTiempoFactura(Timestamp.valueOf(factura.getFechaEntrada()), Timestamp.valueOf(factura.getFechaSalida()));
		
		if(factura.getVehiculo().getTipo().equals(Constantes.TIPO_VEHICULO_CARRO)) {
			cobroTipoCarro.cobro(tiempoFactura, factura);
		}else {
			cobroTipoMoto.cobro(tiempoFactura, factura);
		}
		
		facturaRepository.save(factura);
		return mapeoDTO.convertirFacturaEntidad(factura);
	}

	@Override
	public List<FacturaDTO> consultarFacturasActivas() {
		List<FacturaDTO> listaFacturas = new ArrayList<>();
		for(Factura factura : facturaRepository.consultarFacturasActivas()) {
			listaFacturas.add(mapeoDTO.convertirFacturaEntidad(factura));
		}
		return listaFacturas;
	}
	
}
