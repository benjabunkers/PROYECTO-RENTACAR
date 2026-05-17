package com.rentacar.ms_clientes.controller;



import com.rentacar.ms_clientes.dto.ClienteDTO;
import com.rentacar.ms_clientes.dto.ClienteRequestDTO;
import com.rentacar.ms_clientes.service.ClienteService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteDTO>> buscar(@RequestParam String texto) {
        return ResponseEntity.ok(service.buscarPorEmail(texto));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteRequestDTO d) {
        ClienteDTO c = service.save(d);
        return ResponseEntity.created(URI.create("/api/v1/clientes/" + c.id())).body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(
            @PathVariable Integer id, @Valid @RequestBody ClienteRequestDTO d) {
        return ResponseEntity.ok(service.update(id, d));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
