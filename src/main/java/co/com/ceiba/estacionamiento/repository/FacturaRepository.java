package co.com.ceiba.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entity.Factura;

@Repository("facturaRepository")
public interface FacturaRepository extends JpaRepository<Factura, Long>{

	@Query(
			value = "SELECT COUNT(f) FROM Factura f WHERE f.tipo = ?1 AND f.fecha_entrada = null",
			nativeQuery = true)
	int consultarCantidadVehiculosPorTipo(String tipo);
}
