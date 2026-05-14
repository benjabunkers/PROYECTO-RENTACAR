package com.rentacar.ms_vehiculos.mapper;

import com.rentacar.ms_vehiculos.dto.VehiculoDTO;
import com.rentacar.ms_vehiculos.model.Categoria;
import com.rentacar.ms_vehiculos.model.Vehiculo;

public class VehiculoMapper {

    public static VehiculoDTO toDTO(Vehiculo vehiculo){
        return new VehiculoDTO(
                vehiculo.getId(),
                vehiculo.getModelo(),
                vehiculo.getPrecioDiario(),
                vehiculo.getAnio(),
                vehiculo.getDisponible(),
                vehiculo.getFechaIngreso(),
                vehiculo.getCategoria().getId()
                );
    }
    public static Vehiculo toEntity(VehiculoDTO dto, Categoria categoria){
        return new Vehiculo(
                dto.getId(),
                dto.getModelo(),
                dto.getPrecioDiario(),
                dto.getAnio(),
                dto.getDisponible(),
                dto.getFechaIngreso(),
                categoria
        );
    }
}
