package co.com.ceiba.estacionamiento.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.persistence.entity.Vehiculo;
import co.com.ceiba.estacionamiento.persistence.repository.VehiculoRepository;

@Service
public class VehiculoService {
	
	@Autowired
	VehiculoRepository vehiculoRepository;
	
	public void registrarVehiculo(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
	}

}
