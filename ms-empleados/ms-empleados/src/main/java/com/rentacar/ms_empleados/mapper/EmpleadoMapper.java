package com.rentacar.ms_empleados.mapper;

import com.rentacar.ms_empleados.dto.EmpleadoDTO;
import com.rentacar.ms_empleados.dto.EmpleadoRequestDTO;
import com.rentacar.ms_empleados.model.Empleado;

public class EmpleadoMapper {

    public static EmpleadoDTO toDTO(Empleado empleado) {
        return new EmpleadoDTO(
                empleado.getId(),
                empleado.getNombreCompleto(),
                empleado.getEmail(),
                empleado.getCargo(),
                empleado.getSueldo(),
                empleado.getFechaContratacion(),
                empleado.getActivo(),
                empleado.getTelefono()
        );
    }

    public static Empleado toEntity(EmpleadoRequestDTO dto) {
        Empleado empleado = new Empleado();
        updateEntity(empleado, dto);
        return empleado;
    }

    public static void updateEntity(Empleado empleado, EmpleadoRequestDTO dto) {
        empleado.setNombreCompleto(dto.getNombreCompleto());
        empleado.setEmail(dto.getEmail());
        empleado.setCargo(dto.getCargo());
        empleado.setSueldo(dto.getSueldo());
        empleado.setFechaContratacion(dto.getFechaContratacion());
        empleado.setActivo(dto.getActivo());
        empleado.setTelefono(dto.getTelefono());
    }

}
