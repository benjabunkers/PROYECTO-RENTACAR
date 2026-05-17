package com.rentacar.ms_clientes.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record DireccionRequestDTO(
        @NotBlank @Size(min = 2, max = 100)
        String calle,

        @NotNull @Positive
        Integer numero,

        @NotBlank @Size(min = 2, max = 100)
        String comuna,

        @NotBlank @Size(min = 2, max = 100)
        String ciudad,

        @NotNull @Positive
        Integer codigoPostal,

        Boolean principal,

        @NotNull @PastOrPresent
        LocalDate fechaCreacion,

        @NotNull @Positive
        Integer clienteId) {}