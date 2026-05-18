package cl.duoc.arriendo.sucursales.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RegionDTO(
    Integer id,
    String nombre,
    String codigo,
    Integer numeroRegion,
    BigDecimal superficieKm2,
    Boolean activa,
    LocalDate fechaCreacion) {}
