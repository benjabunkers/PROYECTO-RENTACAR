package com.rentacar.ms_clientes.service;

import com.rentacar.ms_clientes.exception.ResourceNotFoundException;
import com.rentacar.ms_clientes.model.Cliente;
import com.rentacar.ms_clientes.dto.ClienteDTO;
import com.rentacar.ms_clientes.mapper.ClienteMapper;
import com.rentacar.ms_clientes.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private static final Logger log =
            LoggerFactory.getLogger(ClienteService.class);

    // LISTAR
    public List<ClienteDTO> findAll() {

        log.info("Listando clientes");

        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public ClienteDTO findById(Integer id) {

        log.info("Buscando cliente por id: {}", id);

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cliente no encontrado"
                        ));

        return ClienteMapper.toDTO(cliente);
    }

    // GUARDAR
    public ClienteDTO save(ClienteDTO dto) {

        try {

            log.info("Guardando cliente");

            Cliente cliente = ClienteMapper.toEntity(dto);

            cliente = clienteRepository.save(cliente);

            return ClienteMapper.toDTO(cliente);

        } catch (Exception e) {

            log.error("Error al guardar cliente: {}", e.getMessage());

            throw e;
        }
    }

    // ACTUALIZAR
    public ClienteDTO update(Integer id, ClienteDTO dto) {

        log.info("Actualizando cliente");

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cliente no encontrado"
                        ));

        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEdad(dto.getEdad());
        cliente.setActivo(dto.getActivo());
        cliente.setFechaRegistro(dto.getFechaRegistro());

        cliente = clienteRepository.save(cliente);

        return ClienteMapper.toDTO(cliente);
    }

    // ELIMINAR
    public void delete(Integer id) {

        log.info("Eliminando cliente");

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cliente no encontrado"
                        ));

        clienteRepository.delete(cliente);
    }
}
