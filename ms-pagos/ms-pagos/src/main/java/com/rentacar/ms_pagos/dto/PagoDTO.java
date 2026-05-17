package com.rentacar.ms_pagos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {

    private Integer id;
    private Integer reservaId;
    private String metodoPago;
    private Double monto;
    private LocalDate fechaPago;
    private Integer cuotas;
    private String estadoPago;
    private String codigoTransaccion;
    private Boolean pagado;


}
