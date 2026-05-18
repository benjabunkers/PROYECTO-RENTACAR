package cl.duoc.arriendo.sucursales.repository;

import cl.duoc.arriendo.sucursales.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Optional<Region> findByCodigo(String codigo);
}
