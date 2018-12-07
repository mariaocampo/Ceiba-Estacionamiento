package co.com.ceiba.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

}
