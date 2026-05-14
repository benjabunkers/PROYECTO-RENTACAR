package com.rentacar.ms_empleados.service;

import com.rentacar.ms_empleados.dto.EmpleadoDTO;
import com.rentacar.ms_empleados.exception.ResourceNotFoundException;
import com.rentacar.ms_empleados.mapper.EmpleadoMapper;
import com.rentacar.ms_empleados.model.Empleado;
import com.rentacar.ms_empleados.repository.EmpleadoRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    private static final Logger log =
            LoggerFactory.getLogger(EmpleadoService.class);

    // LISTAR
    public List<EmpleadoDTO> findAll() {

        log.info("Listando empleados");

        return empleadoRepository.findAll()
                .stream()
                .map(EmpleadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public EmpleadoDTO findById(Integer id) {

        log.info("Buscando empleado por id: {}", id);

        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Empleado no encontrado"
                        ));

        return EmpleadoMapper.toDTO(empleado);
    }

    // GUARDAR
    public EmpleadoDTO save(EmpleadoDTO dto) {

        try {

            log.info("Guardando empleado");

            Empleado empleado =
                    EmpleadoMapper.toEntity(dto);

            empleado = empleadoRepository.save(empleado);

            return EmpleadoMapper.toDTO(empleado);

        } catch (Exception e) {

            log.error("Error al guardar empleado: {}",
                    e.getMessage());

            throw e;
        }
    }

    // ACTUALIZAR
    public EmpleadoDTO update(
            Integer id,
            EmpleadoDTO dto) {

        log.info("Actualizando empleado");

        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Empleado no encontrado"
                        ));

        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setCargo(dto.getCargo());
        empleado.setEmail(dto.getEmail());
        empleado.setSueldo(dto.getSueldo());
        empleado.setFechaContratacion(
                dto.getFechaContratacion()
        );
        empleado.setActivo(dto.getActivo());

        empleado = empleadoRepository.save(empleado);

        return EmpleadoMapper.toDTO(empleado);
    }

    // ELIMINAR
    public void delete(Integer id) {

        log.info("Eliminando empleado");

        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Empleado no encontrado"
                        ));

        empleadoRepository.delete(empleado);
    }

    // BUSCAR POR CARGO
    public List<EmpleadoDTO> findByCargo(String cargo) {

        log.info("Buscando empleados por cargo");

        return empleadoRepository
                .findByCargoContainingIgnoreCase(cargo)
                .stream()
                .map(EmpleadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR ACTIVOS
    public List<EmpleadoDTO> findByActivo(Boolean activo) {

        log.info("Buscando empleados activos");

        return empleadoRepository
                .findByActivo(activo)
                .stream()
                .map(EmpleadoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
