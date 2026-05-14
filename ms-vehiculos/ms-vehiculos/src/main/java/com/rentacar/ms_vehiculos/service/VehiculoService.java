package com.rentacar.ms_vehiculos.service;

import com.rentacar.ms_vehiculos.dto.VehiculoDTO;
import com.rentacar.ms_vehiculos.mapper.VehiculoMapper;
import com.rentacar.ms_vehiculos.model.Categoria;
import com.rentacar.ms_vehiculos.model.Vehiculo;
import com.rentacar.ms_vehiculos.repository.CategoriaRepository;
import com.rentacar.ms_vehiculos.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;
    private final CategoriaRepository categoriaRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository, CategoriaRepository categoriaRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<VehiculoDTO> listarVehiculos() {
        return vehiculoRepository.findAll()
                .stream()
                .map(VehiculoMapper::toDTO)
                .toList();
    }

    public VehiculoDTO obtenerVehiculoPorId(Integer id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        return VehiculoMapper.toDTO(vehiculo);
    }

    public VehiculoDTO crearVehiculo(VehiculoDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Vehiculo vehiculo = VehiculoMapper.toEntity(dto, categoria);
        vehiculo = vehiculoRepository.save(vehiculo);

        return VehiculoMapper.toDTO(vehiculo);
    }

    public VehiculoDTO actualizarVehiculo(Integer id, VehiculoDTO dto) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        // actualizar campos
        vehiculo.setModelo(dto.getModelo());
        vehiculo.setPrecioDiario(dto.getPrecioDiario());
        vehiculo.setAnio(dto.getAnio());
        vehiculo.setDisponible(dto.getDisponible());
        vehiculo.setFechaIngreso(dto.getFechaIngreso());

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        vehiculo.setCategoria(categoria);

        vehiculo = vehiculoRepository.save(vehiculo);
        return VehiculoMapper.toDTO(vehiculo);
    }

    public void eliminarVehiculo(Integer id) {
        vehiculoRepository.deleteById(id);
    }

    // ⚡ Query Method adicional
    public List<VehiculoDTO> obtenerVehiculosDisponiblesPorPrecio(Double precioMaximo) {
        return vehiculoRepository.findByDisponibleTrueAndPrecioDiarioLessThan(precioMaximo)
                .stream()
                .map(VehiculoMapper::toDTO)
                .toList();
    }



}
