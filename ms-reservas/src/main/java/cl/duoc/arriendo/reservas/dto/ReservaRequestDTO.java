package cl.duoc.arriendo.reservas.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservaRequestDTO(
    @NotBlank @Size(min = 2, max = 100) String codigoReserva,
    @NotNull @Positive Integer clienteId,
    @NotNull @Positive Integer vehiculoId,
    @NotNull @Future LocalDate fechaInicio,
    @NotNull @Future LocalDate fechaFin,
    @NotNull @Positive Integer dias,
    @NotNull @DecimalMin("0.0") BigDecimal total,
    Boolean activa,
    @NotNull @PastOrPresent LocalDate fechaCreacion,
    @NotNull @Positive Integer estadoReservaId) {}
