package com.rentacar.ms_reportes.mapper;

import com.rentacar.ms_reportes.dto.ReporteDTO;
import com.rentacar.ms_reportes.model.Reporte;

public class ReporteMapper {

    // ENTITY → DTO
    public static ReporteDTO toDTO(Reporte reporte) {

        return new ReporteDTO(
                reporte.getId(),
                reporte.getTitulo(),
                reporte.getDescripcion(),
                reporte.getTipoReporte(),
                reporte.getFechaGeneracion(),
                reporte.getGeneradoPor(),
                reporte.getActivo()
        );
    }

    // DTO → ENTITY
    public static Reporte toEntity(ReporteDTO dto) {

        Reporte reporte = new Reporte();

        reporte.setId(dto.getId());
        reporte.setTitulo(dto.getTitulo());
        reporte.setDescripcion(dto.getDescripcion());
        reporte.setTipoReporte(dto.getTipoReporte());
        reporte.setFechaGeneracion(dto.getFechaGeneracion());
        reporte.setGeneradoPor(dto.getGeneradoPor());
        reporte.setActivo(dto.getActivo());

        return reporte;
    }
}
