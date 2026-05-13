package com.rentacar.ms_clientes.service;

import com.rentacar.ms_clientes.dto.DireccionDTO;
import com.rentacar.ms_clientes.exception.ResourceNotFoundException;
import com.rentacar.ms_clientes.mapper.DireccionMapper;
import com.rentacar.ms_clientes.model.Direccion;
import com.rentacar.ms_clientes.repository.DireccionRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class DireccionService {

    private final DireccionRepository direccionRepository;

    private static final Logger log =
            LoggerFactory.getLogger(DireccionService.class);

    // LISTAR
    public List<DireccionDTO> findAll() {

        log.info("Listando direcciones");

        return direccionRepository.findAll()
                .stream()
                .map(DireccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public DireccionDTO findById(Integer id) {

        log.info("Buscando direccion por id: {}", id);

        Direccion direccion = direccionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Direccion no encontrada"
                        ));

        return DireccionMapper.toDTO(direccion);
    }

    // GUARDAR
    public DireccionDTO save(DireccionDTO dto) {

        try {

            log.info("Guardando direccion");

            Direccion direccion = DireccionMapper.toEntity(dto);

            direccion = direccionRepository.save(direccion);

            return DireccionMapper.toDTO(direccion);

        } catch (Exception e) {

            log.error("Error al guardar direccion: {}", e.getMessage());

            throw e;
        }
    }

    // ACTUALIZAR
    public DireccionDTO update(Integer id, DireccionDTO dto) {

        log.info("Actualizando direccion");

        Direccion direccion = direccionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Direccion no encontrada"
                        ));

        direccion.setCalle(dto.getCalle());
        direccion.setCiudad(dto.getCiudad());
        direccion.setComuna(dto.getComuna());
        direccion.setNumero(dto.getNumero());
        direccion.setPrincipal(dto.getPrincipal());
        direccion.setFechaRegistro(dto.getFechaRegistro());

        direccion = direccionRepository.save(direccion);

        return DireccionMapper.toDTO(direccion);
    }

    // ELIMINAR
    public void delete(Integer id) {

        log.info("Eliminando direccion");

        Direccion direccion = direccionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Direccion no encontrada"
                        ));

        direccionRepository.delete(direccion);
    }
}
