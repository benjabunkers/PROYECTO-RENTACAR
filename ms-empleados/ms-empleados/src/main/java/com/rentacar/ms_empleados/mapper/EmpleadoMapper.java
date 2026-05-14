package com.rentacar.ms_empleados.mapper;

import com.rentacar.ms_empleados.dto.EmpleadoDTO;
import com.rentacar.ms_empleados.model.Empleado;

public class EmpleadoMapper {
    // ENTITY → DTO
    public static EmpleadoDTO toDTO(Empleado empleado) {

        return new EmpleadoDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getCargo(),
                empleado.getEmail(),
                empleado.getSueldo(),
                empleado.getFechaContratacion(),
                empleado.getActivo()
        );
    }

    // DTO → ENTITY
    public static Empleado toEntity(EmpleadoDTO dto) {

        Empleado empleado = new Empleado();

        empleado.setId(dto.getId());
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setCargo(dto.getCargo());
        empleado.setEmail(dto.getEmail());
        empleado.setSueldo(dto.getSueldo());
        empleado.setFechaContratacion(dto.getFechaContratacion());
        empleado.setActivo(dto.getActivo());

        return empleado;
    }

}
