package com.rentacar.ms_reservas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

    private Integer id;

    private String codigoReserva ;

    private String observacion;

    private Double total ;

    private Integer diasReserva ;

    private Boolean activa ;

    private LocalDate fechaInicio;
}
