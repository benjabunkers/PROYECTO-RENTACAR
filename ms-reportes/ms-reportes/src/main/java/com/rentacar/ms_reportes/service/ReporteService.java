package com.rentacar.ms_reportes.service;

import com.rentacar.ms_reportes.dto.ReporteDTO;
import com.rentacar.ms_reportes.exception.ResourceNotFoundException;
import com.rentacar.ms_reportes.mapper.ReporteMapper;
import com.rentacar.ms_reportes.model.Reporte;
import com.rentacar.ms_reportes.repository.ReporteRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ReporteService {

    private final ReporteRepository reporteRepository;

    private static final Logger log =
            LoggerFactory.getLogger(ReporteService.class);

    // LISTAR
    public List<ReporteDTO> findAll() {

        log.info("Listando reportes");

        return reporteRepository.findAll()
                .stream()
                .map(ReporteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public ReporteDTO findById(Integer id) {

        log.info("Buscando reporte por id: {}", id);

        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reporte no encontrado"
                        ));

        return ReporteMapper.toDTO(reporte);
    }

    // GUARDAR
    public ReporteDTO save(ReporteDTO dto) {

        try {

            log.info("Guardando reporte");

            Reporte reporte =
                    ReporteMapper.toEntity(dto);

            reporte = reporteRepository.save(reporte);

            return ReporteMapper.toDTO(reporte);

        } catch (Exception e) {

            log.error("Error al guardar reporte: {}",
                    e.getMessage());

            throw e;
        }
    }

    // ACTUALIZAR
    public ReporteDTO update(
            Integer id,
            ReporteDTO dto) {

        log.info("Actualizando reporte");

        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reporte no encontrado"
                        ));

        reporte.setTitulo(dto.getTitulo());
        reporte.setDescripcion(dto.getDescripcion());
        reporte.setTipoReporte(dto.getTipoReporte());
        reporte.setFechaGeneracion(
                dto.getFechaGeneracion()
        );
        reporte.setGeneradoPor(dto.getGeneradoPor());
        reporte.setActivo(dto.getActivo());

        reporte = reporteRepository.save(reporte);

        return ReporteMapper.toDTO(reporte);
    }

    // ELIMINAR
    public void delete(Integer id) {

        log.info("Eliminando reporte");

        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reporte no encontrado"
                        ));

        reporteRepository.delete(reporte);
    }

    // BUSCAR POR TIPO
    public List<ReporteDTO> findByTipoReporte(
            String tipoReporte) {

        log.info("Buscando reportes por tipo");

        return reporteRepository
                .findByTipoReporteContainingIgnoreCase(
                        tipoReporte
                )
                .stream()
                .map(ReporteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR ACTIVOS
    public List<ReporteDTO> findByActivo(Boolean activo) {

        log.info("Buscando reportes activos");

        return reporteRepository
                .findByActivo(activo)
                .stream()
                .map(ReporteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
