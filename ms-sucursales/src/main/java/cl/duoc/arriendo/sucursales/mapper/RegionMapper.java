package cl.duoc.arriendo.sucursales.mapper;

import cl.duoc.arriendo.sucursales.dto.*;
import cl.duoc.arriendo.sucursales.model.Region;

public final class RegionMapper {
  private RegionMapper() {}

  public static RegionDTO toDTO(Region x) {
    return new RegionDTO(
        x.getId(),
        x.getNombre(),
        x.getCodigo(),
        x.getNumeroRegion(),
        x.getSuperficieKm2(),
        x.getActiva(),
        x.getFechaCreacion());
  }

  public static Region toEntity(RegionRequestDTO d) {
    Region x = new Region();
    updateEntity(x, d);
    return x;
  }

  public static void updateEntity(Region x, RegionRequestDTO d) {
    x.setNombre(d.nombre());
    x.setCodigo(d.codigo());
    x.setNumeroRegion(d.numeroRegion());
    x.setSuperficieKm2(d.superficieKm2());
    x.setActiva(d.activa());
    x.setFechaCreacion(d.fechaCreacion());
  }
}
