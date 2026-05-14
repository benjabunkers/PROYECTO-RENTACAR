package com.rentacar.ms_reportes.controller;

import com.rentacar.ms_reportes.dto.ReporteDTO;
import com.rentacar.ms_reportes.service.ReporteService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reportes")
@RequiredArgsConstructor

public class ReporteController {

    private final ReporteService reporteService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<ReporteDTO>> findAll() {

        return ResponseEntity.ok(
                reporteService.findAll()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ReporteDTO> findById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                reporteService.findById(id)
        );
    }

    // CREAR
    @PostMapping
    public ResponseEntity<ReporteDTO> save(
            @Valid @RequestBody ReporteDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        reporteService.save(dto)
                );
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ReporteDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody ReporteDTO dto) {

        return ResponseEntity.ok(
                reporteService.update(id, dto)
        );
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        reporteService.delete(id);

        return ResponseEntity.noContent().build();
    }

    // BUSCAR POR TIPO
    @GetMapping("/tipo/{tipoReporte}")
    public ResponseEntity<List<ReporteDTO>>
    findByTipoReporte(
            @PathVariable String tipoReporte) {

        return ResponseEntity.ok(
                reporteService.findByTipoReporte(
                        tipoReporte
                )
        );
    }

    // BUSCAR ACTIVOS
    @GetMapping("/activo/{activo}")
    public ResponseEntity<List<ReporteDTO>>
    findByActivo(
            @PathVariable Boolean activo) {

        return ResponseEntity.ok(
                reporteService.findByActivo(
                        activo
                )
        );
    }
}
