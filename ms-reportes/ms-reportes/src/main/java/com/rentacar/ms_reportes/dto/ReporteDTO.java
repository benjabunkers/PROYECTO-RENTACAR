package com.rentacar.ms_reportes.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReporteDTO {

    private Integer id;
    private String titulo;
    private String tipoReporte;
    private Integer totalReservas;
    private Double totalIngresos;
    private LocalDate fechaGeneracion;
    private Boolean generado;
    private String observacion;
}
