package com.rentacar.ms_pagos.service;

import com.rentacar.ms_pagos.client.ReservaClient;
import com.rentacar.ms_pagos.dto.*;
import com.rentacar.ms_pagos.exception.ResourceNotFoundException;
import com.rentacar.ms_pagos.mapper.PagoMapper;
import com.rentacar.ms_pagos.model.Pago;
import com.rentacar.ms_pagos.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PagoService {

    private final PagoRepository pagoRepository;
    private final ReservaClient reservaClient;
    private static final Logger log = LoggerFactory.getLogger(PagoService.class);

    public List<PagoDTO> findAll() {
        log.info("Listando pagos");
        return pagoRepository.findAll().stream().map(PagoMapper::toDTO).toList();
    }

    public PagoDTO findById(Integer id) {
        log.info("Buscando pago por id {}", id);
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        return PagoMapper.toDTO(pago);
    }

    public PagoDTO save(PagoRequestDTO dto) {
        log.info("Guardando pago");
        validarReserva(dto);
        Pago pago = pagoRepository.save(PagoMapper.toEntity(dto));
        return PagoMapper.toDTO(pago);
    }

    public PagoDTO update(Integer id, PagoRequestDTO dto) {
        log.info("Actualizando pago {}", id);
        validarReserva(dto);

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));

        PagoMapper.updateEntity(pago, dto);
        return PagoMapper.toDTO(pagoRepository.save(pago));
    }

    public void delete(Integer id) {
        log.info("Eliminando pago {}", id);
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        pagoRepository.delete(pago);
    }

    public List<PagoDTO> findByMetodoPago(String metodoPago) {
        return pagoRepository.findByMetodoPagoContainingIgnoreCase(metodoPago)
                .stream().map(PagoMapper::toDTO).toList();
    }

    public List<PagoDTO> findByEstadoPago(String estadoPago) {
        return pagoRepository.findByEstadoPagoContainingIgnoreCase(estadoPago)
                .stream().map(PagoMapper::toDTO).toList();
    }

    public List<PagoDTO> findByMontoBetween(Double montoMinimo, Double montoMaximo) {
        if (montoMinimo > montoMaximo) {
            throw new IllegalArgumentException("El monto minimo no puede ser mayor al monto maximo");
        }

        return pagoRepository.buscarPorRangoMontoOrdenadoPorFechaDesc(montoMinimo, montoMaximo)
                .stream().map(PagoMapper::toDTO).toList();
    }

    private void validarReserva(PagoRequestDTO dto) {
        ReservaDTO reserva = reservaClient.obtenerReservaPorId(dto.getReservaId());

        if (reserva == null || reserva.getId() == null) {
            throw new ResourceNotFoundException("Reserva no encontrada");
        }

        if (reserva.getMontoTotal() != null && dto.getMonto() > reserva.getMontoTotal()) {
            throw new IllegalArgumentException("El monto del pago no puede superar el monto total de la reserva");
        }
    }
}
