package cl.duoc.arriendo.sucursales.controller;

import cl.duoc.arriendo.sucursales.dto.*;
import cl.duoc.arriendo.sucursales.service.SucursalService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {
  private final SucursalService service;

  public SucursalController(SucursalService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<SucursalDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<SucursalDTO> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @GetMapping("/operativas")
  public ResponseEntity<List<SucursalDTO>> operativas() {
    return ResponseEntity.ok(service.listarOperativasOrdenadas());
  }

  @PostMapping
  public ResponseEntity<SucursalDTO> create(@Valid @RequestBody SucursalRequestDTO d) {
    SucursalDTO c = service.save(d);
    return ResponseEntity.created(URI.create("/api/v1/sucursales/" + c.id())).body(c);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SucursalDTO> update(
      @PathVariable Integer id, @Valid @RequestBody SucursalRequestDTO d) {
    return ResponseEntity.ok(service.update(id, d));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
