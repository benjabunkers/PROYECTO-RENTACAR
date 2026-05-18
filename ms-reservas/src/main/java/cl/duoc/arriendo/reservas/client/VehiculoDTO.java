package cl.duoc.arriendo.reservas.client;

import java.math.BigDecimal;

public record VehiculoDTO(
    Integer id, String patente, BigDecimal precioArriendoDiario, Boolean disponible) {}
