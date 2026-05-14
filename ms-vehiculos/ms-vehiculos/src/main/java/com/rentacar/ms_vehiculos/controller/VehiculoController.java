package com.rentacar.ms_vehiculos.controller;


import com.rentacar.ms_vehiculos.dto.VehiculoDTO;
import com.rentacar.ms_vehiculos.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDTO>> listarVehiculos() {
        return ResponseEntity.ok(vehiculoService.listarVehiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> obtenerVehiculoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(vehiculoService.obtenerVehiculoPorId(id));
    }

    @PostMapping
    public ResponseEntity<VehiculoDTO> crearVehiculo(@RequestBody VehiculoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoService.crearVehiculo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoDTO> actualizarVehiculo(@PathVariable Integer id, @RequestBody VehiculoDTO dto) {
        return ResponseEntity.ok(vehiculoService.actualizarVehiculo(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Integer id) {
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }

    // ⚡ Nuevo endpoint de consulta
    @GetMapping("/disponibles")
    public ResponseEntity<List<VehiculoDTO>> obtenerVehiculosDisponiblesPorPrecio(@RequestParam Double precioMaximo) {
        return ResponseEntity.ok(vehiculoService.obtenerVehiculosDisponiblesPorPrecio(precioMaximo));
    }
}

