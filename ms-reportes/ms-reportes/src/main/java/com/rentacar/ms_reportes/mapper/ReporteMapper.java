package com.rentacar.ms_reportes.mapper;

import com.rentacar.ms_reportes.dto.ReporteDTO;
import com.rentacar.ms_reportes.dto.ReporteRequestDTO;
import com.rentacar.ms_reportes.model.Reporte;

public class ReporteMapper {

    public static ReporteDTO toDTO(Reporte reporte) {
        return new ReporteDTO(
                reporte.getId(),
                reporte.getTitulo(),
                reporte.getTipoReporte(),
                reporte.getTotalReservas(),
                reporte.getTotalIngresos(),
                reporte.getFechaGeneracion(),
                reporte.getGenerado(),
                reporte.getObservacion()
        );
    }

    public static Reporte toEntity(ReporteRequestDTO dto) {
        Reporte reporte = new Reporte();
        updateEntity(reporte, dto);
        return reporte;
    }

    public static void updateEntity(Reporte reporte, ReporteRequestDTO dto) {
        reporte.setTitulo(dto.getTitulo());
        reporte.setTipoReporte(dto.getTipoReporte());
        reporte.setTotalReservas(dto.getTotalReservas());
        reporte.setTotalIngresos(dto.getTotalIngresos());
        reporte.setFechaGeneracion(dto.getFechaGeneracion());
        reporte.setGenerado(dto.getGenerado());
        reporte.setObservacion(dto.getObservacion());
    }
}
