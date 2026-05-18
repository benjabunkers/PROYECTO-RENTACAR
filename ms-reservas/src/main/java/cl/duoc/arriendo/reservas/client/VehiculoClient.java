package cl.duoc.arriendo.reservas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-vehiculos", url = "http://localhost:8082")
public interface VehiculoClient {
  @GetMapping("/api/v1/vehiculos/{id}")
  VehiculoDTO obtenerPorId(@PathVariable Integer id);
}
