package com.rentacar.ms_vehiculos.mapper;

import com.rentacar.ms_vehiculos.dto.CategoriaDTO;
import com.rentacar.ms_vehiculos.dto.VehiculoDTO;
import com.rentacar.ms_vehiculos.model.Categoria;
import com.rentacar.ms_vehiculos.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaMapper {
    public static CategoriaDTO toDTO(Categoria categoria) {
        //  Protegemos contra null
        List<VehiculoDTO> vehiculosDTO = categoria.getVehiculos() != null
                ? categoria.getVehiculos().stream()
                .map(VehiculoMapper::toDTO)
                .toList()
                : new ArrayList<>();

        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getTipoVehiculo(),
                categoria.getCapacidad(),
                categoria.isActiva(),
                categoria.getFechaCreacion(),
                vehiculosDTO
        );
    }

    public static Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        categoria.setTipoVehiculo(dto.getTipoVehiculo());
        categoria.setCapacidad(dto.getCapacidad());
        categoria.setActiva(dto.isActiva());
        categoria.setFechaCreacion(dto.getFechaCreacion());


        categoria.setVehiculos(new ArrayList<>());

        return categoria;
    }
}
