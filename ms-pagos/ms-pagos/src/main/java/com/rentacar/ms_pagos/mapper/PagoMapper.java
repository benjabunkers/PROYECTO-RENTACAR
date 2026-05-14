package com.rentacar.ms_pagos.mapper;

import com.rentacar.ms_pagos.model.Pago;
import com.rentacar.ms_pagos.dto.PagoDTO;



public class PagoMapper {

    public static PagoDTO toDTO(Pago pago) {

        return new PagoDTO(
                pago.getId(),
                pago.getMetodoPago(),
                pago.getMonto(),
                pago.getFechaPago(),
                pago.getCuotas(),
                pago.getEstadoPago(),
                pago.getPagado()
        );
    }

    public static Pago toEntity(PagoDTO dto) {

        Pago pago = new Pago();

        pago.setId(dto.getId());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago());
        pago.setCuotas(dto.getCuotas());
        pago.setEstadoPago(dto.getEstadoPago());
        pago.setPagado(dto.getPagado());

        return pago;
    }
}
