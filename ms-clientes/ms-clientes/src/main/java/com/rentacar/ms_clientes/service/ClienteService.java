package com.rentacar.ms_clientes.service;

import java.util.List;

import com.rentacar.ms_clientes.dto.ClienteDTO;
import com.rentacar.ms_clientes.dto.ClienteRequestDTO;
import com.rentacar.ms_clientes.exception.ResourceNotFoundException;
import com.rentacar.ms_clientes.mapper.ClienteMapper;
import com.rentacar.ms_clientes.model.Cliente;
import com.rentacar.ms_clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> findAll() {
        log.info("Listando clientes");
        return repository.findAll().stream().map(ClienteMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Integer id) {
        log.info("Buscando Cliente {}", id);
        return repository
                .findById(id)
                .map(ClienteMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id " + id));
    }

    public ClienteDTO save(ClienteRequestDTO d) {
        try {
            log.info("Guardando Cliente");
            Cliente x = ClienteMapper.toEntity(d);
            return ClienteMapper.toDTO(repository.save(x));
        } catch (RuntimeException ex) {
            log.error("Error al guardar Cliente", ex);
            throw ex;
        }
    }

    public ClienteDTO update(Integer id, ClienteRequestDTO d) {
        Cliente x =
                repository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id " + id));
        ClienteMapper.updateEntity(x, d);
        return ClienteMapper.toDTO(repository.save(x));
    }

    public void delete(Integer id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("Cliente no encontrado con id " + id);
        repository.deleteById(id);
    }

    public List<ClienteDTO> buscarPorEmail(String texto) {
        return repository.findByEmailContainingIgnoreCase(texto).stream()
                .map(ClienteMapper::toDTO)
                .toList();
    }


}
