package com.rentacar.ms_clientes.dto;
import java.time.LocalDate;

public record DireccionDTO(
        Integer id,
        String calle,
        Integer numero,
        String comuna,
        String ciudad,
        Integer codigoPostal,
        Boolean principal,
        LocalDate fechaCreacion,
        Integer clienteId) {}