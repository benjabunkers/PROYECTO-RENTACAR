package cl.duoc.arriendo.sucursales.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record RegionRequestDTO(
    @NotBlank @Size(min = 2, max = 100) String nombre,
    @NotBlank @Size(min = 2, max = 100) String codigo,
    @NotNull @Positive Integer numeroRegion,
    @NotNull @DecimalMin("0.0") BigDecimal superficieKm2,
    Boolean activa,
    @NotNull @PastOrPresent LocalDate fechaCreacion) {}
