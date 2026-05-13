package com.rentacar.ms_clientes.controller;


import com.rentacar.ms_clientes.dto.DireccionDTO;
import com.rentacar.ms_clientes.service.DireccionService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
@RequiredArgsConstructor


public class DireccionController {

    private final DireccionService direccionService;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<DireccionDTO>> findAll() {

        return ResponseEntity.ok(
                direccionService.findAll()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<DireccionDTO> findById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                direccionService.findById(id)
        );
    }

    // GUARDAR
    @PostMapping
    public ResponseEntity<DireccionDTO> save(
            @Valid @RequestBody DireccionDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(direccionService.save(dto));
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<DireccionDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody DireccionDTO dto) {

        return ResponseEntity.ok(
                direccionService.update(id, dto)
        );
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        direccionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
