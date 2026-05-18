package cl.duoc.arriendo.reservas.repository;

import cl.duoc.arriendo.reservas.model.Reserva;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
  @Query("select r from Reserva r where r.fechaInicio >= :fecha order by r.fechaInicio desc")
  List<Reserva> buscarDesdeFecha(@Param("fecha") LocalDate fecha);
}
