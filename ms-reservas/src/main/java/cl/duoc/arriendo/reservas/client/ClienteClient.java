package cl.duoc.arriendo.reservas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-clientes", url = "http://localhost:8081")
public interface ClienteClient {
  @GetMapping("/api/v1/clientes/{id}")
  ClienteDTO obtenerPorId(@PathVariable Integer id);
}
