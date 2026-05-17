package com.rentacar.ms_reservas.mapper;

import com.rentacar.ms_reservas.dto.EstadoReservaDTO;
import com.rentacar.ms_reservas.dto.ReservaDTO;
import com.rentacar.ms_reservas.model.EstadoReserva;

import java.util.ArrayList;
import java.util.List;

public class EstadoReservaMapper {



    public static EstadoReservaDTO toDTO(EstadoReserva estado) {
        EstadoReservaDTO dto = new EstadoReservaDTO();
        dto.setId(estado.getId());
        dto.setNombreEstado(estado.getNombreEstado());
        dto.setDescripcion(estado.getDescripcion());
        dto.setColorEstado(estado.getColorEstado());
        dto.setPrioridad(estado.getPrioridad());
        dto.setActivo(estado.isActivo());
        dto.setFechaCreacion(estado.getFechaCreacion());
        return dto;
    }

    public static EstadoReserva toEntity(EstadoReservaDTO dto) {
        EstadoReserva estado = new EstadoReserva();
        estado.setId(dto.getId());
        estado.setNombreEstado(dto.getNombreEstado());
        estado.setDescripcion(dto.getDescripcion());
        estado.setColorEstado(dto.getColorEstado());
        estado.setPrioridad(dto.getPrioridad());
        estado.setActivo(dto.isActivo());
        estado.setFechaCreacion(dto.getFechaCreacion());
        return estado;
    }
}
