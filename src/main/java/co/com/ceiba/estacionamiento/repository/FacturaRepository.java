package co.com.ceiba.estacionamiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entity.Factura;

@Repository("facturaRepository")
public interface FacturaRepository extends JpaRepository<Factura, Long>{

	@Query(
			value = "SELECT COUNT(*) FROM Factura f LEFT OUTER JOIN Vehiculo v ON v.placa = f.placa WHERE v.tipo = ?1 AND f.fecha_salida IS null",
			nativeQuery = true)
	public int consultarCantidadVehiculosPorTipo(String tipo);
	
	@Query(
			value = "SELECT * FROM Factura f LEFT OUTER JOIN Vehiculo v ON v.placa = f.placa WHERE f.placa = ?1",
			nativeQuery = true)
	public Factura consultarFacturaPorPlaca(String placa);
	
	@Query(
			value = "SELECT * FROM Factura f LEFT OUTER JOIN Vehiculo v ON v.placa = f.placa WHERE f.fecha_salida IS null",
			nativeQuery = true)
	public List<Factura> consultarFacturasActivas();
}
