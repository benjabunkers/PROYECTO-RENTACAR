package com.rentacar.ms_empleados.controller;

import com.rentacar.ms_empleados.dto.EmpleadoDTO;
import com.rentacar.ms_empleados.dto.EmpleadoRequestDTO;
import com.rentacar.ms_empleados.service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> findAll() {
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(empleadoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> save(@Valid @RequestBody EmpleadoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody EmpleadoRequestDTO dto) {
        return ResponseEntity.ok(empleadoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/activos/anio/{anio}")
    public ResponseEntity<List<EmpleadoDTO>> findActivosPorAnioContratacion(
            @PathVariable Integer anio) {
        return ResponseEntity.ok(empleadoService.findActivosPorAnioContratacion(anio));
    }
}
