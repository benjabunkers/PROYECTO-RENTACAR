package com.rentacar.ms_reportes.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReporteRequestDTO {
    @NotBlank(message = "El titulo es obligatorio")
    @Size(min = 2, max = 100, message = "El titulo debe tener entre 2 y 100 caracteres")
    private String titulo;

    @NotBlank(message = "El tipo de reporte es obligatorio")
    @Size(min = 2, max = 50, message = "El tipo de reporte debe tener entre 2 y 50 caracteres")
    private String tipoReporte;

    @NotNull(message = "El total de reservas es obligatorio")
    @Min(value = 0, message = "El total de reservas no puede ser negativo")
    private Integer totalReservas;

    @NotNull(message = "El total de ingresos es obligatorio")
    @PositiveOrZero(message = "El total de ingresos no puede ser negativo")
    private Double totalIngresos;

    @NotNull(message = "La fecha de generacion es obligatoria")
    @PastOrPresent(message = "La fecha de generacion no puede ser futura")
    private LocalDate fechaGeneracion;

    @NotNull(message = "Debe indicar si el reporte fue generado")
    private Boolean generado;

    @NotBlank(message = "La observacion es obligatoria")
    @Size(min = 2, max = 200, message = "La observacion debe tener entre 2 y 200 caracteres")
    private String observacion;
}
