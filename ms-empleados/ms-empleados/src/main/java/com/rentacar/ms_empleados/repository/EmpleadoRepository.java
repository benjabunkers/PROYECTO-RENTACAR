package com.rentacar.ms_empleados.repository;


import com.rentacar.ms_empleados.model.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado, Integer>{

    List<Empleado> findByCargoContainingIgnoreCase(
            String cargo
    );

    List<Empleado> findByActivo(Boolean activo);
}
