package cl.duoc.arriendo.reservas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservaDTO(
    Integer id,
    String codigoReserva,
    Integer clienteId,
    Integer vehiculoId,
    LocalDate fechaInicio,
    LocalDate fechaFin,
    Integer dias,
    BigDecimal total,
    Boolean activa,
    LocalDate fechaCreacion,
    Integer estadoReservaId) {}
