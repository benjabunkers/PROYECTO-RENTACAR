package cl.duoc.arriendo.sucursales.repository;

import cl.duoc.arriendo.sucursales.model.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
  @Query(
      value = "SELECT * FROM sucursales WHERE operativa = true ORDER BY nombre ASC",
      nativeQuery = true)
  List<Sucursal> listarOperativasOrdenadas();
}
