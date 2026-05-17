package com.rentacar.ms_clientes.mapper;

import com.rentacar.ms_clientes.dto.ClienteDTO;
import com.rentacar.ms_clientes.dto.ClienteRequestDTO;
import com.rentacar.ms_clientes.model.Cliente;

public final class ClienteMapper {
    private ClienteMapper() {}

    public static ClienteDTO toDTO(Cliente x) {
        return new ClienteDTO(
                x.getId(),
                x.getNombre(),
                x.getEmail(),
                x.getTelefono(),
                x.getNumeroLicencia(),
                x.getEdad(),
                x.getActivo(),
                x.getFechaRegistro());
    }

    public static Cliente toEntity(ClienteRequestDTO d) {
        Cliente x = new Cliente();
        updateEntity(x, d);
        return x;
    }

    public static void updateEntity(Cliente x, ClienteRequestDTO d) {
        x.setNombre(d.nombre());
        x.setEmail(d.email());
        x.setTelefono(d.telefono());
        x.setNumeroLicencia(d.numeroLicencia());
        x.setEdad(d.edad());
        x.setActivo(d.activo());
        x.setFechaRegistro(d.fechaRegistro());
    }
}



