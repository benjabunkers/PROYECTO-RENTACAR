package cl.duoc.arriendo.reservas.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record EstadoReservaRequestDTO(
    @NotBlank @Size(min = 2, max = 100) String nombre,
    @NotBlank @Size(min = 2, max = 100) String descripcion,
    @NotNull @Positive Integer ordenFlujo,
    Boolean requierePago,
    Boolean activo,
    @NotNull @PastOrPresent LocalDate fechaCreacion) {}
