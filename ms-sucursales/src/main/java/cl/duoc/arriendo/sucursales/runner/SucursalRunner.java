package cl.duoc.arriendo.sucursales.runner;


import cl.duoc.arriendo.sucursales.model.Region;
import cl.duoc.arriendo.sucursales.model.Sucursal;
import cl.duoc.arriendo.sucursales.repository.RegionRepository;
import cl.duoc.arriendo.sucursales.repository.SucursalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class SucursalRunner {
    @Bean
    CommandLineRunner initSucursales(SucursalRepository sucursalRepository,
                                     RegionRepository regionRepository) {
        return args -> {
            if (sucursalRepository.count() == 0) {
                // Buscar una región existente para asociar sucursales
                Region regionMetropolitana = regionRepository.findByCodigo("RM")
                        .orElseThrow(() -> new RuntimeException("Debe existir la Región Metropolitana"));

                Sucursal sucursal1 = new Sucursal();
                sucursal1.setNombre("Sucursal Santiago Centro");
                sucursal1.setDireccion("Av. Libertador Bernardo O'Higgins 1234");
                sucursal1.setTelefono("+56 2 23456789");
                sucursal1.setCodigoSucursal("STGO-CEN");
                sucursal1.setCapacidadVehiculos(50);
                sucursal1.setOperativa(true);
                sucursal1.setFechaApertura(LocalDate.of(2020, 5, 10));
                sucursal1.setRegion(regionMetropolitana);

                Sucursal sucursal2 = new Sucursal();
                sucursal2.setNombre("Sucursal Providencia");
                sucursal2.setDireccion("Av. Providencia 4567");
                sucursal2.setTelefono("+56 2 98765432");
                sucursal2.setCodigoSucursal("PROV-01");
                sucursal2.setCapacidadVehiculos(30);
                sucursal2.setOperativa(true);
                sucursal2.setFechaApertura(LocalDate.of(2021, 3, 15));
                sucursal2.setRegion(regionMetropolitana);

                sucursalRepository.save(sucursal1);
                sucursalRepository.save(sucursal2);

                System.out.println("Sucursales iniciales insertadas correctamente.");
            }
        };
    }
}
