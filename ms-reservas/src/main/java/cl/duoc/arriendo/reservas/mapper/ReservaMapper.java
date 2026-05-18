package cl.duoc.arriendo.reservas.mapper;

import cl.duoc.arriendo.reservas.dto.*;
import cl.duoc.arriendo.reservas.model.Reserva;

public final class ReservaMapper {
  private ReservaMapper() {}

  public static ReservaDTO toDTO(Reserva x) {
    return new ReservaDTO(
        x.getId(),
        x.getCodigoReserva(),
        x.getClienteId(),
        x.getVehiculoId(),
        x.getFechaInicio(),
        x.getFechaFin(),
        x.getDias(),
        x.getTotal(),
        x.getActiva(),
        x.getFechaCreacion(),
        x.getEstadoReserva() != null ? x.getEstadoReserva().getId() : null);
  }

  public static Reserva toEntity(ReservaRequestDTO d) {
    Reserva x = new Reserva();
    updateEntity(x, d);
    return x;
  }

  public static void updateEntity(Reserva x, ReservaRequestDTO d) {
    x.setCodigoReserva(d.codigoReserva());
    x.setClienteId(d.clienteId());
    x.setVehiculoId(d.vehiculoId());
    x.setFechaInicio(d.fechaInicio());
    x.setFechaFin(d.fechaFin());
    x.setDias(d.dias());
    x.setTotal(d.total());
    x.setActiva(d.activa());
    x.setFechaCreacion(d.fechaCreacion());
  }
}
