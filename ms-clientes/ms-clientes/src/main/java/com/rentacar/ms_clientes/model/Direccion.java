package com.rentacar.ms_clientes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "DIRECCIONES")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String calle;

    private String ciudad;

    private String comuna;

    private Integer numero;

    private Boolean principal;

    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
