package com.rentacar.ms_pagos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reserva_id", nullable = false)
    private Integer reservaId;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @Column(nullable = false)
    private Double monto;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = false)
    private Integer cuotas;

    @Column(name = "estado_pago", nullable = false, length = 30)
    private String estadoPago;

    @Column(name = "codigo_transaccion", nullable = false, unique = true, length = 80)
    private String codigoTransaccion;

    @Column(nullable = false)
    private Boolean pagado = false;
}
