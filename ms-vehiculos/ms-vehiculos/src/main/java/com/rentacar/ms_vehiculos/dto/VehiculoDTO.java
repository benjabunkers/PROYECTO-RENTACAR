package com.rentacar.ms_vehiculos.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private Integer id;

    @Size(min=2, max=100)
    @NotBlank
    private String modelo;

    @DecimalMin("0.0") @Digits(integer=8, fraction=2)
    private Double precioDiario;
    @Positive
    @Min(value = 0)
    private Integer anio ;

    private Boolean disponible ;

    @NotNull
    @PastOrPresent
    private LocalDate fechaIngreso ;

}
