package cl.duoc.arriendo.reservas.controller;

import cl.duoc.arriendo.reservas.dto.*;
import cl.duoc.arriendo.reservas.service.ReservaService;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {
  private final ReservaService service;

  public ReservaController(ReservaService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<ReservaDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReservaDTO> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @GetMapping("/desde")
  public ResponseEntity<List<ReservaDTO>> desde(@RequestParam LocalDate fecha) {
    return ResponseEntity.ok(service.buscarDesdeFecha(fecha));
  }

  @PostMapping
  public ResponseEntity<ReservaDTO> create(@Valid @RequestBody ReservaRequestDTO d) {
    ReservaDTO c = service.save(d);
    return ResponseEntity.created(URI.create("/api/v1/reservas/" + c.id())).body(c);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ReservaDTO> update(
      @PathVariable Integer id, @Valid @RequestBody ReservaRequestDTO d) {
    return ResponseEntity.ok(service.update(id, d));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
