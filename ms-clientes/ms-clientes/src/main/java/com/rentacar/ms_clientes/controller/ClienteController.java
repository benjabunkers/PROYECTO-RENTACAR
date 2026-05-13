package com.rentacar.ms_clientes.controller;

import com.rentacar.ms_clientes.dto.ClienteDTO;
import com.rentacar.ms_clientes.service.ClienteService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService clienteService;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {

        return ResponseEntity.ok(
                clienteService.findAll()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                clienteService.findById(id)
        );
    }

    // GUARDAR
    @PostMapping
    public ResponseEntity<ClienteDTO> save(
            @Valid @RequestBody ClienteDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.save(dto));
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody ClienteDTO dto) {

        return ResponseEntity.ok(
                clienteService.update(id, dto)
        );
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        clienteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
