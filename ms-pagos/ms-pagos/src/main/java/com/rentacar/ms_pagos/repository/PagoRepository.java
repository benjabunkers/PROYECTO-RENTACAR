package com.rentacar.ms_pagos.repository;

import com.rentacar.ms_pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer>{

    List<Pago> findByMetodoPagoContainingIgnoreCase(String metodoPago);
    List<Pago> findByEstadoPagoContainingIgnoreCase(String estadoPago);
    List<Pago> findByPagado(Boolean pagado);

    @Query("""
            SELECT p
            FROM Pago p
            WHERE p.monto BETWEEN :montoMinimo AND :montoMaximo
            ORDER BY p.fechaPago DESC
            """)
    List<Pago> buscarPorRangoMontoOrdenadoPorFechaDesc(
            @Param("montoMinimo") Double montoMinimo,
            @Param("montoMaximo") Double montoMaximo
    );

}
