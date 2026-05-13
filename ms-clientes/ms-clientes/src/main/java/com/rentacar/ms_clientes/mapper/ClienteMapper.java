package com.rentacar.ms_clientes.mapper;

import com.rentacar.ms_clientes.model.Cliente;
import com.rentacar.ms_clientes.dto.ClienteDTO;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getEdad(),
                cliente.getActivo(),
                cliente.getFechaRegistro()
        );
    }

    public static Cliente toEntity(ClienteDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEdad(dto.getEdad());
        cliente.setActivo(dto.getActivo());
        cliente.setFechaRegistro(dto.getFechaRegistro());
        return cliente;
    }


}
