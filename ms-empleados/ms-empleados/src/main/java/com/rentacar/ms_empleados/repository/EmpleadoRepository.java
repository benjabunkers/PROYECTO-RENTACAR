package com.rentacar.ms_empleados.repository;


import com.rentacar.ms_empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado, Integer>{

    @Query(value = """
            SELECT *
            FROM empleados
            WHERE activo = true
            AND YEAR(fecha_contratacion) = :anio
            """, nativeQuery = true)
    List<Empleado> buscarEmpleadosActivosPorAnioContratacion(@Param("anio") Integer anio);
}
