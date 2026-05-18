package cl.duoc.arriendo.sucursales.mapper;

import cl.duoc.arriendo.sucursales.dto.*;
import cl.duoc.arriendo.sucursales.model.Sucursal;

public final class SucursalMapper {
  private SucursalMapper() {}

  public static SucursalDTO toDTO(Sucursal x) {
    return new SucursalDTO(
        x.getId(),
        x.getNombre(),
        x.getDireccion(),
        x.getTelefono(),
        x.getCodigoSucursal(),
        x.getCapacidadVehiculos(),
        x.getOperativa(),
        x.getFechaApertura(),
        x.getRegion() != null ? x.getRegion().getId() : null);
  }

  public static Sucursal toEntity(SucursalRequestDTO d) {
    Sucursal x = new Sucursal();
    updateEntity(x, d);
    return x;
  }

  public static void updateEntity(Sucursal x, SucursalRequestDTO d) {
    x.setNombre(d.nombre());
    x.setDireccion(d.direccion());
    x.setTelefono(d.telefono());
    x.setCodigoSucursal(d.codigoSucursal());
    x.setCapacidadVehiculos(d.capacidadVehiculos());
    x.setOperativa(d.operativa());
    x.setFechaApertura(d.fechaApertura());
  }
}
