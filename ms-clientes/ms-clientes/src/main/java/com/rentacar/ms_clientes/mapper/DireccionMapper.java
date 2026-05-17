package com.rentacar.ms_clientes.mapper;

import com.rentacar.ms_clientes.dto.DireccionRequestDTO;
import com.rentacar.ms_clientes.model.Direccion;
import com.rentacar.ms_clientes.dto.DireccionDTO;

public class DireccionMapper {

    private DireccionMapper() {}

    public static DireccionDTO toDTO(Direccion x) {
        return new DireccionDTO(
                x.getId(),
                x.getCalle(),
                x.getNumero(),
                x.getComuna(),
                x.getCiudad(),
                x.getCodigoPostal(),
                x.getPrincipal(),
                x.getFechaCreacion(),
                x.getCliente() != null ? x.getCliente().getId() : null);
    }

    public static Direccion toEntity(DireccionRequestDTO d) {
        Direccion x = new Direccion();
        updateEntity(x, d);
        return x;
    }

    public static void updateEntity(Direccion x, DireccionRequestDTO d) {
        x.setCalle(d.calle());
        x.setNumero(d.numero());
        x.setComuna(d.comuna());
        x.setCiudad(d.ciudad());
        x.setCodigoPostal(d.codigoPostal());
        x.setPrincipal(d.principal());
        x.setFechaCreacion(d.fechaCreacion());
    }
}
