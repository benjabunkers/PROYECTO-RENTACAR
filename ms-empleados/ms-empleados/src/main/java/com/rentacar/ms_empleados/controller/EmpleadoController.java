package com.rentacar.ms_empleados.controller;

import com.rentacar.ms_empleados.dto.EmpleadoDTO;
import com.rentacar.ms_empleados.service.EmpleadoService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> findAll() {

        return ResponseEntity.ok(
                empleadoService.findAll()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                empleadoService.findById(id)
        );
    }

    // CREAR
    @PostMapping
    public ResponseEntity<EmpleadoDTO> save(
            @Valid @RequestBody EmpleadoDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        empleadoService.save(dto)
                );
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody EmpleadoDTO dto) {

        return ResponseEntity.ok(
                empleadoService.update(id, dto)
        );
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        empleadoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    // BUSCAR POR CARGO
    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<EmpleadoDTO>> findByCargo(
            @PathVariable String cargo) {

        return ResponseEntity.ok(
                empleadoService.findByCargo(cargo)
        );
    }

    // BUSCAR POR ACTIVO
    @GetMapping("/activo/{activo}")
    public ResponseEntity<List<EmpleadoDTO>> findByActivo(
            @PathVariable Boolean activo) {

        return ResponseEntity.ok(
                empleadoService.findByActivo(activo)
        );
    }
}
