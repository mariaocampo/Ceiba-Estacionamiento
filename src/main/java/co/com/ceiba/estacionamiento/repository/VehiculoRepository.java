package co.com.ceiba.estacionamiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entity.Vehiculo;

@Repository("vehiculoRepository")
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

	public Vehiculo findByPlaca(String placa);
	
	public List<Vehiculo> findByTipo(String tipo);
}
