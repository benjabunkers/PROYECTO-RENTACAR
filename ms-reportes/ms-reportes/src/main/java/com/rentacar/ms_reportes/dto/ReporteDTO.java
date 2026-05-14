package com.rentacar.ms_reportes.dto;


import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReporteDTO {

    private Integer id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotBlank(message = "El tipo de reporte es obligatorio")
    private String tipoReporte;

    @NotNull(message = "La fecha es obligatoria")
    @PastOrPresent
    private LocalDate fechaGeneracion;

    @NotBlank(message = "El usuario es obligatorio")
    private String generadoPor;

    private Boolean activo;
}
