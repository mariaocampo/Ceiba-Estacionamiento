package co.com.ceiba.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entity.Factura;

@Repository("facturaRepository")
public interface FacturaRepository extends JpaRepository<Factura, Long>{

	@Query(
			value = "SELECT COUNT(*) FROM Factura f LEFT OUTER JOIN Vehiculo v ON v.placa = f.placa WHERE v.tipo = ?1 AND f.fecha_salida = null",
			nativeQuery = true)
	int consultarCantidadVehiculosPorTipo(String tipo);
}
