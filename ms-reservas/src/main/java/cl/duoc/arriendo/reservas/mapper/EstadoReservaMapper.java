package cl.duoc.arriendo.reservas.mapper;

import cl.duoc.arriendo.reservas.dto.*;
import cl.duoc.arriendo.reservas.model.EstadoReserva;

public final class EstadoReservaMapper {
  private EstadoReservaMapper() {}

  public static EstadoReservaDTO toDTO(EstadoReserva x) {
    return new EstadoReservaDTO(
        x.getId(),
        x.getNombre(),
        x.getDescripcion(),
        x.getOrdenFlujo(),
        x.getRequierePago(),
        x.getActivo(),
        x.getFechaCreacion());
  }

  public static EstadoReserva toEntity(EstadoReservaRequestDTO d) {
    EstadoReserva x = new EstadoReserva();
    updateEntity(x, d);
    return x;
  }

  public static void updateEntity(EstadoReserva x, EstadoReservaRequestDTO d) {
    x.setNombre(d.nombre());
    x.setDescripcion(d.descripcion());
    x.setOrdenFlujo(d.ordenFlujo());
    x.setRequierePago(d.requierePago());
    x.setActivo(d.activo());
    x.setFechaCreacion(d.fechaCreacion());
  }
}
