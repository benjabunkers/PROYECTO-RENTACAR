package cl.duoc.arriendo.reservas.controller;

import cl.duoc.arriendo.reservas.dto.*;
import cl.duoc.arriendo.reservas.service.EstadoReservaService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estados-reserva")
public class EstadoReservaController {
  private final EstadoReservaService service;

  public EstadoReservaController(EstadoReservaService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<EstadoReservaDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<EstadoReservaDTO> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<EstadoReservaDTO> create(@Valid @RequestBody EstadoReservaRequestDTO d) {
    EstadoReservaDTO c = service.save(d);
    return ResponseEntity.created(URI.create("/api/v1/estados-reserva/" + c.id())).body(c);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EstadoReservaDTO> update(
      @PathVariable Integer id, @Valid @RequestBody EstadoReservaRequestDTO d) {
    return ResponseEntity.ok(service.update(id, d));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
