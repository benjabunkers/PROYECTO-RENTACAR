package com.rentacar.ms_clientes.dto;

import java.time.LocalDate;

public record ClienteDTO(
        Integer id,
        String nombre,
        String email,
        String telefono,
        String numeroLicencia,
        Integer edad,
        Boolean activo,
        LocalDate fechaRegistro) {}
