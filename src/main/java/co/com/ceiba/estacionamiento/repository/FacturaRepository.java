package co.com.ceiba.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
