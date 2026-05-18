package cl.duoc.arriendo.sucursales.config;

import cl.duoc.arriendo.sucursales.model.*;
import cl.duoc.arriendo.sucursales.repository.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

@Configuration
public class DataLoader {
  @Bean
  CommandLineRunner cargarDatos(
      RegionRepository regionRepository, SucursalRepository sucursalRepository) {
    return args -> {
      if (regionRepository.count() == 0) {
        Region a = r("Metropolitana", "RM", 13, "15403"),
            b = r("Biobio", "BIO", 8, "23890"),
            c = r("Valparaiso", "VAL", 5, "16396");
        regionRepository.save(a);
        regionRepository.save(b);
        regionRepository.save(c);
        sucursalRepository.save(
            s("Sucursal Santiago", "Alameda 1000", "223334444", "SCL", 80, true, a));
        sucursalRepository.save(
            s("Sucursal Concepcion", "OHiggins 250", "412223333", "CCP", 45, true, b));
        sucursalRepository.save(
            s("Sucursal Valparaiso", "Brasil 1450", "322224444", "VAP", 35, true, c));
      }
    };
  }

  Region r(String n, String co, Integer nr, String su) {
    Region x = new Region();
    x.setNombre(n);
    x.setCodigo(co);
    x.setNumeroRegion(nr);
    x.setSuperficieKm2(new BigDecimal(su));
    x.setActiva(true);
    x.setFechaCreacion(LocalDate.now());
    return x;
  }

  Sucursal s(String n, String d, String t, String co, Integer ca, Boolean op, Region r) {
    Sucursal x = new Sucursal();
    x.setNombre(n);
    x.setDireccion(d);
    x.setTelefono(t);
    x.setCodigoSucursal(co);
    x.setCapacidadVehiculos(ca);
    x.setOperativa(op);
    x.setFechaApertura(LocalDate.now());
    x.setRegion(r);
    return x;
  }
}
