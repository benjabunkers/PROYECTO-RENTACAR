package com.rentacar.ms_empleados.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmpleadoRequestDTO {

    @NotBlank(message = "El nombre completo es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombreCompleto;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe tener un formato valido")
    @Size(max = 100, message = "El email no puede superar 100 caracteres")
    private String email;

    @NotBlank(message = "El cargo es obligatorio")
    @Size(min = 2, max = 50, message = "El cargo debe tener entre 2 y 50 caracteres")
    private String cargo;

    @NotNull(message = "El sueldo es obligatorio")
    @Positive(message = "El sueldo debe ser mayor a 0")
    private Double sueldo;

    @NotNull(message = "La fecha de contratacion es obligatoria")
    @PastOrPresent(message = "La fecha de contratacion no puede ser futura")
    private LocalDate fechaContratacion;

    @NotNull(message = "El estado activo es obligatorio")
    private Boolean activo;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(min = 8, max = 20, message = "El telefono debe tener entre 8 y 20 caracteres")
    private String telefono;
}
