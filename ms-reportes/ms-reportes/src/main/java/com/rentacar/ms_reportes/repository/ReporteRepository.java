package com.rentacar.ms_reportes.repository;

import com.rentacar.ms_reportes.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReporteRepository extends JpaRepository<Reporte, Integer>{


}
