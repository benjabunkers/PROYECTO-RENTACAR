package com.rentacar.ms_empleados.mapper;

import com.rentacar.ms_empleados.dto.EmpleadoDTO;
import com.rentacar.ms_empleados.model.Empleado;

public class EmpleadoMapper {
    public static EmpleadoDTO toDTO(Empleado empleado){
        return new EmpleadoDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getCorreo(),
                empleado.getSalario(),
                empleado.getActivo(),
                empleado.getFechaContratacion()
        );
    }

    public static Empleado toEntity(EmpleadoDTO dto){
        return new Empleado(
                dto.getId(),
                dto.getNombre(),
                dto.getCorreo(),
                dto.getSalario(),
                dto.getActivo(),
                dto.getFechaContratacion()
        );
    }

}
