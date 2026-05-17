package com.rentacar.ms_reportes.client;

import com.rentacar.ms_reportes.dto.PagoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ms-pagos", url = "${app.clients.pagos-url}")

public interface PagoClient {

    @GetMapping("/api/v1/pagos")
    List<PagoDTO> listarPagos();
}
