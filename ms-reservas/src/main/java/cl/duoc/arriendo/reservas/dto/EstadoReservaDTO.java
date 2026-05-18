package cl.duoc.arriendo.reservas.dto;

import java.time.LocalDate;

public record EstadoReservaDTO(
    Integer id,
    String nombre,
    String descripcion,
    Integer ordenFlujo,
    Boolean requierePago,
    Boolean activo,
    LocalDate fechaCreacion) {}
