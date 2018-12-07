package co.com.ceiba.estacionamiento.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.persistence.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

}
