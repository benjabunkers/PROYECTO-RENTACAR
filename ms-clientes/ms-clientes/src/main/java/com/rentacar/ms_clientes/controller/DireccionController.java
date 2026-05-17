package com.rentacar.ms_clientes.controller;


import com.rentacar.ms_clientes.dto.DireccionDTO;
import com.rentacar.ms_clientes.dto.DireccionRequestDTO;
import com.rentacar.ms_clientes.service.DireccionService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/direcciones")


public class DireccionController {

    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DireccionDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DireccionDTO> create(@Valid @RequestBody DireccionRequestDTO d) {
        DireccionDTO c = service.save(d);
        return ResponseEntity.created(URI.create("/api/v1/direcciones/" + c.id())).body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionDTO> update(
            @PathVariable Integer id, @Valid @RequestBody DireccionRequestDTO d) {
        return ResponseEntity.ok(service.update(id, d));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
