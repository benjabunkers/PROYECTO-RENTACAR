package com.rentacar.ms_reportes.client;
import com.rentacar.ms_reportes.dto.ReservaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ms-reservas", url = "${app.clients.reservas-url}")

public interface ReservaClient {

    @GetMapping("/api/v1/reservas")
    List<ReservaDTO> listarReservas();
}
