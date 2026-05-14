package com.rentacar.ms_pagos.service;

import com.rentacar.ms_pagos.dto.PagoDTO;
import com.rentacar.ms_pagos.exception.ResourceNotFoundException;
import com.rentacar.ms_pagos.mapper.PagoMapper;
import com.rentacar.ms_pagos.model.Pago;
import com.rentacar.ms_pagos.repository.PagoRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PagoService {

    private final PagoRepository pagoRepository;

    private static final Logger log =
            LoggerFactory.getLogger(PagoService.class);

    // LISTAR
    public List<PagoDTO> findAll() {

        log.info("Listando pagos");

        return pagoRepository.findAll()
                .stream()
                .map(PagoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public PagoDTO findById(Integer id) {

        log.info("Buscando pago por id: {}", id);

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Pago no encontrado"
                        ));

        return PagoMapper.toDTO(pago);
    }

    // GUARDAR
    public PagoDTO save(PagoDTO dto) {

        try {

            log.info("Guardando pago");

            Pago pago = PagoMapper.toEntity(dto);

            pago = pagoRepository.save(pago);

            return PagoMapper.toDTO(pago);

        } catch (Exception e) {

            log.error("Error al guardar pago: {}", e.getMessage());

            throw e;
        }
    }

    // ACTUALIZAR
    public PagoDTO update(Integer id, PagoDTO dto) {

        log.info("Actualizando pago");

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Pago no encontrado"
                        ));

        // actualizar campo por campo
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago());
        pago.setCuotas(dto.getCuotas());
        pago.setEstadoPago(dto.getEstadoPago());
        pago.setPagado(dto.getPagado());

        pago = pagoRepository.save(pago);

        return PagoMapper.toDTO(pago);
    }

    // ELIMINAR
    public void delete(Integer id) {

        log.info("Eliminando pago");

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Pago no encontrado"
                        ));

        pagoRepository.delete(pago);
    }

    // BUSCAR POR METODO DE PAGO
    public List<PagoDTO> findByMetodoPago(String metodoPago) {

        log.info("Buscando pagos por método");

        return pagoRepository
                .findByMetodoPagoContainingIgnoreCase(
                        metodoPago
                )
                .stream()
                .map(PagoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ESTADO
    public List<PagoDTO> findByEstadoPago(String estadoPago) {

        log.info("Buscando pagos por estado");

        return pagoRepository
                .findByEstadoPagoContainingIgnoreCase(
                        estadoPago
                )
                .stream()
                .map(PagoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
