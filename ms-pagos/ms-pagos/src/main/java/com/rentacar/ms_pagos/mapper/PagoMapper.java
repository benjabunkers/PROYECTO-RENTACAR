package com.rentacar.ms_pagos.mapper;

import com.rentacar.ms_pagos.dto.PagoDTO;
import com.rentacar.ms_pagos.dto.PagoRequestDTO;
import com.rentacar.ms_pagos.model.Pago;


public class PagoMapper {

    public static PagoDTO toDTO(Pago pago) {
        return new PagoDTO(
                pago.getId(),
                pago.getReservaId(),
                pago.getMetodoPago(),
                pago.getMonto(),
                pago.getFechaPago(),
                pago.getCuotas(),
                pago.getEstadoPago(),
                pago.getCodigoTransaccion(),
                pago.getPagado()
        );
    }

    public static Pago toEntity(PagoRequestDTO dto) {
        Pago pago = new Pago();
        updateEntity(pago, dto);
        return pago;
    }

    public static void updateEntity(Pago pago, PagoRequestDTO dto) {
        pago.setReservaId(dto.getReservaId());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago());
        pago.setCuotas(dto.getCuotas());
        pago.setEstadoPago(dto.getEstadoPago());
        pago.setCodigoTransaccion(dto.getCodigoTransaccion());
        pago.setPagado(dto.getPagado());
    }
}
