package com.rentacar.ms_reportes.service;

import com.rentacar.ms_reportes.client.PagoClient;
import com.rentacar.ms_reportes.client.ReservaClient;
import com.rentacar.ms_reportes.dto.PagoDTO;
import com.rentacar.ms_reportes.dto.ReporteDTO;
import com.rentacar.ms_reportes.dto.ReporteRequestDTO;
import com.rentacar.ms_reportes.dto.ReservaDTO;
import com.rentacar.ms_reportes.exception.ResourceNotFoundException;
import com.rentacar.ms_reportes.mapper.ReporteMapper;
import com.rentacar.ms_reportes.model.Reporte;
import com.rentacar.ms_reportes.repository.ReporteRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ReporteService {

    private final ReporteRepository reporteRepository;
    private final ReservaClient reservaClient;
    private final PagoClient pagoClient;

    private static final Logger log = LoggerFactory.getLogger(ReporteService.class);

    public List<ReporteDTO> findAll() {
        log.info("Listando reportes");
        return reporteRepository.findAll()
                .stream()
                .map(ReporteMapper::toDTO)
                .toList();
    }

    public ReporteDTO findById(Integer id) {
        log.info("Buscando reporte por id {}", id);

        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado"));

        return ReporteMapper.toDTO(reporte);
    }

    public ReporteDTO save(ReporteRequestDTO dto) {
        try {
            log.info("Guardando reporte");
            Reporte reporte = reporteRepository.save(ReporteMapper.toEntity(dto));
            return ReporteMapper.toDTO(reporte);
        } catch (Exception e) {
            log.error("Error al guardar reporte: {}", e.getMessage());
            throw e;
        }
    }

    public ReporteDTO update(Integer id, ReporteRequestDTO dto) {
        try {
            log.info("Actualizando reporte {}", id);

            Reporte reporte = reporteRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado"));

            ReporteMapper.updateEntity(reporte, dto);
            return ReporteMapper.toDTO(reporteRepository.save(reporte));
        } catch (Exception e) {
            log.error("Error al actualizar reporte: {}", e.getMessage());
            throw e;
        }
    }

    public void delete(Integer id) {
        log.info("Eliminando reporte {}", id);

        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado"));

        reporteRepository.delete(reporte);
    }

    public ReporteDTO generarReporteConsolidado() {
        try {
            log.info("Generando reporte consolidado desde reservas y pagos");

            List<ReservaDTO> reservas = reservaClient.listarReservas();
            List<PagoDTO> pagos = pagoClient.listarPagos();

            Integer totalReservas = reservas.size();

            Double totalIngresos = pagos.stream()
                    .filter(pago -> Boolean.TRUE.equals(pago.getPagado()))
                    .mapToDouble(PagoDTO::getMonto)
                    .sum();

            Reporte reporte = new Reporte();
            reporte.setTitulo("Reporte consolidado de arriendos");
            reporte.setTipoReporte("CONSOLIDADO");
            reporte.setTotalReservas(totalReservas);
            reporte.setTotalIngresos(totalIngresos);
            reporte.setFechaGeneracion(LocalDate.now());
            reporte.setGenerado(true);
            reporte.setObservacion("Reporte generado desde ms-reservas y ms-pagos");

            return ReporteMapper.toDTO(reporteRepository.save(reporte));
        } catch (Exception e) {
            log.error("Error al generar reporte consolidado: {}", e.getMessage());
            throw e;
        }
    }
}
