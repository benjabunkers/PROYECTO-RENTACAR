package com.rentacar.ms_clientes.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {

    @NotBlank(message = "La calle es obligatoria")
    private Integer id;

    @NotBlank(message = "La ciudad es obligatoria")
    private String calle;

    @NotBlank(message = "La comuna es obligatoria")
    private String ciudad;

    @NotNull(message = "El número es obligatorio")
    private String comuna;

    private Integer numero;

    private Boolean principal;

    @NotNull @PastOrPresent
    private LocalDate fechaRegistro;
}
