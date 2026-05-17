package com.rentacar.ms_pagos.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PagoRequestDTO {

    @NotNull(message = "El id de la reserva es obligatorio")
    @Min(value = 1, message = "El id de la reserva debe ser mayor a 0")
    private Integer reservaId;

    @NotBlank(message = "El metodo de pago es obligatorio")
    @Size(min = 2, max = 50)
    private String metodoPago;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a 0")
    private Double monto;

    @NotNull(message = "La fecha de pago es obligatoria")
    @PastOrPresent(message = "La fecha de pago no puede ser futura")
    private LocalDate fechaPago;

    @NotNull(message = "Las cuotas son obligatorias")
    @Min(value = 1, message = "Las cuotas deben ser al menos 1")
    private Integer cuotas;

    @NotBlank(message = "El estado del pago es obligatorio")
    @Size(min = 2, max = 30)
    private String estadoPago;

    @NotBlank(message = "El codigo de transaccion es obligatorio")
    @Size(min = 4, max = 80)
    private String codigoTransaccion;

    @NotNull(message = "Debe indicar si el pago esta pagado")
    private Boolean pagado;
}
