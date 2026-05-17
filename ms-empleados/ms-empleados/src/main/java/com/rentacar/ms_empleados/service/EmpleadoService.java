package com.rentacar.ms_empleados.service;

import com.rentacar.ms_empleados.dto.EmpleadoDTO;
import com.rentacar.ms_empleados.dto.EmpleadoRequestDTO;
import com.rentacar.ms_empleados.exception.ResourceNotFoundException;
import com.rentacar.ms_empleados.mapper.EmpleadoMapper;
import com.rentacar.ms_empleados.model.Empleado;
import com.rentacar.ms_empleados.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private static final Logger log = LoggerFactory.getLogger(EmpleadoService.class);

    public List<EmpleadoDTO> findAll() {
        log.info("Listando empleados");
        return empleadoRepository.findAll().stream().map(EmpleadoMapper::toDTO).toList();
    }

    public EmpleadoDTO findById(Integer id) {
        log.info("Buscando empleado por id {}", id);
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));
        return EmpleadoMapper.toDTO(empleado);
    }

    public EmpleadoDTO save(EmpleadoRequestDTO dto) {
        try {
            log.info("Guardando empleado");
            Empleado empleado = empleadoRepository.save(EmpleadoMapper.toEntity(dto));
            return EmpleadoMapper.toDTO(empleado);
        } catch (Exception e) {
            log.error("Error al guardar empleado: {}", e.getMessage());
            throw e;
        }
    }

    public EmpleadoDTO update(Integer id, EmpleadoRequestDTO dto) {
        try {
            log.info("Actualizando empleado {}", id);
            Empleado empleado = empleadoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));

            EmpleadoMapper.updateEntity(empleado, dto);
            return EmpleadoMapper.toDTO(empleadoRepository.save(empleado));
        } catch (Exception e) {
            log.error("Error al actualizar empleado: {}", e.getMessage());
            throw e;
        }
    }

    public void delete(Integer id) {
        log.info("Eliminando empleado {}", id);
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));
        empleadoRepository.delete(empleado);
    }

    public List<EmpleadoDTO> findActivosPorAnioContratacion(Integer anio) {
        log.info("Buscando empleados activos contratados en el anio {}", anio);
        return empleadoRepository.buscarEmpleadosActivosPorAnioContratacion(anio)
                .stream()
                .map(EmpleadoMapper::toDTO)
                .toList();
    }
}
