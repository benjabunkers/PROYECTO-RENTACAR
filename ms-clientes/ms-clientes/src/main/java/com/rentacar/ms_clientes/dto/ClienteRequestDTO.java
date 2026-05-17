package com.rentacar.ms_clientes.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record ClienteRequestDTO(
        @NotBlank @Size(min = 2, max = 100)
        String nombre,

        @NotBlank @Email @Size(max = 120)
        String email,

        @NotBlank @Size(min = 2, max = 100)
        String telefono,

        @NotBlank @Size(min = 2, max = 100)
        String numeroLicencia,

        @NotNull @Min(18)
        Integer edad,

        Boolean activo,

        @NotNull @PastOrPresent
        LocalDate fechaRegistro) {}