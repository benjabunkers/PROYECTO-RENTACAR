package com.rentacar.ms_clientes.service;



import java.util.List;

import com.rentacar.ms_clientes.dto.DireccionDTO;
import com.rentacar.ms_clientes.dto.DireccionRequestDTO;
import com.rentacar.ms_clientes.exception.ResourceNotFoundException;
import com.rentacar.ms_clientes.mapper.DireccionMapper;
import com.rentacar.ms_clientes.model.Cliente;
import com.rentacar.ms_clientes.model.Direccion;
import com.rentacar.ms_clientes.repository.ClienteRepository;
import com.rentacar.ms_clientes.repository.DireccionRepository;
import org.slf4j.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class DireccionService {

    private static final Logger log = LoggerFactory.getLogger(DireccionService.class);
    private final DireccionRepository repository;
    private final ClienteRepository clienteRepository;

    public DireccionService(DireccionRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public List<DireccionDTO> findAll() {
        log.info("Listando direcciones");
        return repository.findAll().stream().map(DireccionMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public DireccionDTO findById(Integer id) {
        log.info("Buscando Direccion {}", id);
        return repository
                .findById(id)
                .map(DireccionMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Direccion no encontrado con id " + id));
    }

    public DireccionDTO save(DireccionRequestDTO d) {
        try {
            log.info("Guardando Direccion");
            Direccion x = DireccionMapper.toEntity(d);
            asignarCliente(x, d.clienteId());
            return DireccionMapper.toDTO(repository.save(x));
        } catch (RuntimeException ex) {
            log.error("Error al guardar Direccion", ex);
            throw ex;
        }
    }

    public DireccionDTO update(Integer id, DireccionRequestDTO d) {
        Direccion x =
                repository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("Direccion no encontrado con id " + id));
        DireccionMapper.updateEntity(x, d);
        asignarCliente(x, d.clienteId());
        return DireccionMapper.toDTO(repository.save(x));
    }

    public void delete(Integer id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("Direccion no encontrado con id " + id);
        repository.deleteById(id);
    }

    private void asignarCliente(Direccion x, Integer id) {
        Cliente p =
                clienteRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id " + id));
        x.setCliente(p);
    }


}
