package com.rentacar.ms_pagos.repository;

import com.rentacar.ms_pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PagoRepository extends JpaRepository<Pago, Integer>{

    // Buscar por metodo de pago
    List<Pago> findByMetodoPagoContainingIgnoreCase(
            String metodoPago
    );

    // Buscar por estado del pago
    List<Pago> findByEstadoPagoContainingIgnoreCase(
            String estadoPago
    );

    // Buscar pagos pagados/no pagados
    List<Pago> findByPagado(Boolean pagado);
}
