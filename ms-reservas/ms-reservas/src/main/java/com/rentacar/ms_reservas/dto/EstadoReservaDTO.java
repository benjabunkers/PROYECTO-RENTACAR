package com.rentacar.ms_reservas.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoReservaDTO {
    @Positive
    @Min(value=0)
    private Integer id;

    @Size(min=2, max=20)
    @NotBlank
    private String nombreEstado;

    @Size(min=2, max=20)
    @NotBlank
    private String descripcion;

    @Size(min=2, max=20)
    @NotBlank
    private String colorEstado;

    @Positive
    @Min(value=0)
    private Integer prioridad;

    private boolean activo;

    @NotNull
    @PastOrPresent
    private LocalDate fechaCreacion;

    private List<ReservaDTO> reservas ;
}
