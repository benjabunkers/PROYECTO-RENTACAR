package com.rentacar.ms_pagos.controller;

import com.rentacar.ms_pagos.dto.*;
import com.rentacar.ms_pagos.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
@RequiredArgsConstructor

public class PagoController {

    private final PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<PagoDTO>> findAll() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(pagoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PagoDTO> save(@Valid @RequestBody PagoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(@PathVariable Integer id, @Valid @RequestBody PagoRequestDTO dto) {
        return ResponseEntity.ok(pagoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/metodo/{metodoPago}")
    public ResponseEntity<List<PagoDTO>> findByMetodoPago(@PathVariable String metodoPago) {
        return ResponseEntity.ok(pagoService.findByMetodoPago(metodoPago));
    }

    @GetMapping("/estado/{estadoPago}")
    public ResponseEntity<List<PagoDTO>> findByEstadoPago(@PathVariable String estadoPago) {
        return ResponseEntity.ok(pagoService.findByEstadoPago(estadoPago));
    }

    @GetMapping("/rango-monto")
    public ResponseEntity<List<PagoDTO>> findByMontoBetween(
            @RequestParam Double montoMinimo,
            @RequestParam Double montoMaximo) {
        return ResponseEntity.ok(pagoService.findByMontoBetween(montoMinimo, montoMaximo));
    }


}
