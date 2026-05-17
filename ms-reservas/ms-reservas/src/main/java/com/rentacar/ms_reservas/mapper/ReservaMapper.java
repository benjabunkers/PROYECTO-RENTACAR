package com.rentacar.ms_reservas.mapper;

import com.rentacar.ms_reservas.dto.EstadoReservaDTO;
import com.rentacar.ms_reservas.dto.ReservaDTO;
import com.rentacar.ms_reservas.model.EstadoReserva;
import com.rentacar.ms_reservas.model.Reserva;

public class ReservaMapper {
    public static ReservaDTO toDTO(Reserva reserva) {
        return new ReservaDTO(
                reserva.getId(),
                reserva.getCodigoReserva(),
                reserva.getObservacion(),
                reserva.getTotal(),
                reserva.getDiasReserva(),
                reserva.getActiva(),
                reserva.getFechaInicio(),
                reserva.getEstadoReserva().getId()

        );
    }

    public static Reserva toEntity(ReservaDTO dto , EstadoReserva estadoReserva){
        return new Reserva(
                dto.getId(),
                dto.getCodigoReserva(),
                dto.getObservacion(),
                dto.getTotal(),
                dto.getDiasReserva(),
                dto.getActiva(),
                dto.getFechaInicio(),
                estadoReserva
        );
    }

}

