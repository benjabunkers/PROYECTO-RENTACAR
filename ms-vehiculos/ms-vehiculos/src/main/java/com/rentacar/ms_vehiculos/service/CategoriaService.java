package com.rentacar.ms_vehiculos.service;

import com.rentacar.ms_vehiculos.dto.CategoriaDTO;
import com.rentacar.ms_vehiculos.mapper.CategoriaMapper;
import com.rentacar.ms_vehiculos.model.Categoria;
import com.rentacar.ms_vehiculos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaMapper::toDTO)
                .toList();
    }

    public CategoriaDTO obtenerCategoriaPorId(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        return CategoriaMapper.toDTO(categoria);
    }

    public CategoriaDTO crearCategoria(CategoriaDTO dto) {
        Categoria categoria = CategoriaMapper.toEntity(dto);
        categoria = categoriaRepository.save(categoria);
        return CategoriaMapper.toDTO(categoria);
    }

    public CategoriaDTO actualizarCategoria(Integer id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        categoria.setTipoVehiculo(dto.getTipoVehiculo());
        categoria.setCapacidad(dto.getCapacidad());
        categoria.setActiva(dto.isActiva());
        categoria.setFechaCreacion(dto.getFechaCreacion());

        categoria = categoriaRepository.save(categoria);
        return CategoriaMapper.toDTO(categoria);
    }

    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
