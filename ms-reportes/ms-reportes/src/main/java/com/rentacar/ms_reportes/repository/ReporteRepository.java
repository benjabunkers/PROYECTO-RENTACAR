package com.rentacar.ms_reportes.repository;

import com.rentacar.ms_reportes.model.Reporte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReporteRepository extends JpaRepository<Reporte, Integer>{

    List<Reporte> findByTipoReporteContainingIgnoreCase(
            String tipoReporte
    );

    List<Reporte> findByActivo(Boolean activo);


}
