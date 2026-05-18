package cl.duoc.arriendo.sucursales.dto;

import java.time.LocalDate;

public record SucursalDTO(
    Integer id,
    String nombre,
    String direccion,
    String telefono,
    String codigoSucursal,
    Integer capacidadVehiculos,
    Boolean operativa,
    LocalDate fechaApertura,
    Integer regionId) {}
