package cl.duoc.arriendo.sucursales.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record SucursalRequestDTO(
    @NotBlank @Size(min = 2, max = 100) String nombre,
    @NotBlank @Size(min = 2, max = 100) String direccion,
    @NotBlank @Size(min = 2, max = 100) String telefono,
    @NotBlank @Size(min = 2, max = 100) String codigoSucursal,
    @NotNull @Positive Integer capacidadVehiculos,
    Boolean operativa,
    @NotNull @PastOrPresent LocalDate fechaApertura,
    @NotNull @Positive Integer regionId) {}
