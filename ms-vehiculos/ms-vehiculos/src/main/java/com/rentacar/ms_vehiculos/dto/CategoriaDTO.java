package com.rentacar.ms_vehiculos.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {


    private Integer id;

    @Size(min = 2, max = 70)
    @NotBlank
    private String nombre;

    @Size(min = 5, max = 500)
    @NotBlank
    private String descripcion;


    private String tipoVehiculo;

    @Positive
    @Min(value = 0)
    private Integer capacidad;

    private boolean activa;
    @NotNull
    @PastOrPresent
    private LocalDate fechaCreacion;

    private List<VehiculoDTO> vehiculos;


}
