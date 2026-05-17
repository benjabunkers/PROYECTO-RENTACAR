package com.rentacar.ms_empleados.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {

    private Integer id;
    private String nombreCompleto;
    private String email;
    private String cargo;
    private Double sueldo;
    private LocalDate fechaContratacion;
    private Boolean activo;
    private String telefono;
}
