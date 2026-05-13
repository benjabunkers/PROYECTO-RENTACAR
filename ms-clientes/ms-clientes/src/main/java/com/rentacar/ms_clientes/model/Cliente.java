package com.rentacar.ms_clientes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "CLIENTES")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String email;

    private String telefono;

    private Integer edad;

    private Boolean activo;

    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "cliente")
    private List<Direccion> direcciones;
}
