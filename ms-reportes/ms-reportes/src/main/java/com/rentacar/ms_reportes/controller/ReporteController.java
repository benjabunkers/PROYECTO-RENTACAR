package com.rentacar.ms_reportes.controller;

import com.rentacar.ms_reportes.dto.ReporteDTO;
import com.rentacar.ms_reportes.dto.ReporteRequestDTO;
import com.rentacar.ms_reportes.service.ReporteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reportes")
@RequiredArgsConstructor

public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<ReporteDTO>> findAll() {
        return ResponseEntity.ok(reporteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(reporteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ReporteDTO> save(@Valid @RequestBody ReporteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reporteService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody ReporteRequestDTO dto) {

        return ResponseEntity.ok(reporteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        reporteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/consolidado")
    public ResponseEntity<ReporteDTO> generarReporteConsolidado() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reporteService.generarReporteConsolidado());
    }

}
