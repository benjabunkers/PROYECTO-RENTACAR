package com.rentacar.ms_clientes.mapper;

import com.rentacar.ms_clientes.model.Direccion;
import com.rentacar.ms_clientes.dto.DireccionDTO;

public class DireccionMapper {

    public static DireccionDTO toDTO(Direccion direccion) {

        return new DireccionDTO(
                direccion.getId(),
                direccion.getCalle(),
                direccion.getCiudad(),
                direccion.getComuna(),
                direccion.getNumero(),
                direccion.getPrincipal(),
                direccion.getFechaRegistro()
        );
    }

    // REQUEST DTO → ENTITY
    public static Direccion toEntity(DireccionDTO dto) {

        Direccion direccion = new Direccion();

        direccion.setCalle(dto.getCalle());
        direccion.setCiudad(dto.getCiudad());
        direccion.setComuna(dto.getComuna());
        direccion.setNumero(dto.getNumero());
        direccion.setPrincipal(dto.getPrincipal());
        direccion.setFechaRegistro(dto.getFechaRegistro());

        return direccion;
    }
}
