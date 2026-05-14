package com.rentacar.ms_pagos.controller;

import com.rentacar.ms_pagos.dto.PagoDTO;
import com.rentacar.ms_pagos.service.PagoService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
@RequiredArgsConstructor

public class PagoController {

    private final PagoService pagoService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<PagoDTO>> findAll() {

        return ResponseEntity.ok(
                pagoService.findAll()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> findById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                pagoService.findById(id)
        );
    }

    // CREAR
    @PostMapping
    public ResponseEntity<PagoDTO> save(
            @Valid @RequestBody PagoDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        pagoService.save(dto)
                );
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody PagoDTO dto) {

        return ResponseEntity.ok(
                pagoService.update(id, dto)
        );
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        pagoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    // BUSCAR POR METODO DE PAGO
    @GetMapping("/metodo/{metodoPago}")
    public ResponseEntity<List<PagoDTO>> findByMetodoPago(
            @PathVariable String metodoPago) {

        return ResponseEntity.ok(
                pagoService.findByMetodoPago(
                        metodoPago
                )
        );
    }

    // BUSCAR POR ESTADO
    @GetMapping("/estado/{estadoPago}")
    public ResponseEntity<List<PagoDTO>> findByEstadoPago(
            @PathVariable String estadoPago) {

        return ResponseEntity.ok(
                pagoService.findByEstadoPago(
                        estadoPago
                )
        );
    }
}
