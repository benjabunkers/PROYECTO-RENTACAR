package com.rentacar.ms_empleados.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String cargo;

    @Column(nullable = false)
    private Double sueldo;

    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fechaContratacion;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(nullable = false, length = 20)
    private String telefono;
}
