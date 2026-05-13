package com.rentacar.ms_empleados.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {

    private Integer id;
    private String nombre ;
    private String correo;
    private Double salario;
    private Boolean activo ;
    private LocalDate fechaContratacion ;
}
