package com.rentacar.ms_pagos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PAGOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String metodoPago;

    private Double monto;

    private LocalDate fechaPago;

    private Integer cuotas;

    private String estadoPago;

    private Boolean pagado;
}
