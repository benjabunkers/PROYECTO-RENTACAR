package cl.duoc.arriendo.sucursales.runner;

import cl.duoc.arriendo.sucursales.model.Region;
import cl.duoc.arriendo.sucursales.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class RegionRunner {
    @Bean
    CommandLineRunner initRegions(RegionRepository regionRepository) {
        return args -> {
            if (regionRepository.count() == 0) {
                Region region1 = new Region();
                region1.setNombre("Región Metropolitana");
                region1.setCodigo("RM");
                region1.setNumeroRegion(13);
                region1.setSuperficieKm2(new BigDecimal("15403.00"));
                region1.setActiva(true);
                region1.setFechaCreacion(LocalDate.now());

                Region region2 = new Region();
                region2.setNombre("Valparaíso");
                region2.setCodigo("V");
                region2.setNumeroRegion(5);
                region2.setSuperficieKm2(new BigDecimal("16396.00"));
                region2.setActiva(true);
                region2.setFechaCreacion(LocalDate.now());

                Region region3 = new Region();
                region3.setNombre("Biobío");
                region3.setCodigo("BIO");
                region3.setNumeroRegion(8);
                region3.setSuperficieKm2(new BigDecimal("37129.00"));
                region3.setActiva(true);
                region3.setFechaCreacion(LocalDate.now());

                regionRepository.save(region1);
                regionRepository.save(region2);
                regionRepository.save(region3);

                System.out.println("Regiones iniciales insertadas correctamente.");
            }
        };
    }
}
