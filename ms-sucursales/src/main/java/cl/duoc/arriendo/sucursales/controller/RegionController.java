package cl.duoc.arriendo.sucursales.controller;

import cl.duoc.arriendo.sucursales.dto.*;
import cl.duoc.arriendo.sucursales.service.RegionService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/regiones")
public class RegionController {
  private final RegionService service;

  public RegionController(RegionService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<RegionDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<RegionDTO> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<RegionDTO> create(@Valid @RequestBody RegionRequestDTO d) {
    RegionDTO c = service.save(d);
    return ResponseEntity.created(URI.create("/api/v1/regiones/" + c.id())).body(c);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RegionDTO> update(
      @PathVariable Integer id, @Valid @RequestBody RegionRequestDTO d) {
    return ResponseEntity.ok(service.update(id, d));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
