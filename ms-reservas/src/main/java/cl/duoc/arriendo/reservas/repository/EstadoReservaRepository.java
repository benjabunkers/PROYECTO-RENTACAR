package cl.duoc.arriendo.reservas.repository;

import cl.duoc.arriendo.reservas.model.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Integer> {}
